/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.type;

import java.util.Optional;
import java.util.function.Supplier;
import karaffe.compiler.tree.AST;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.visitor.Visitor;

public class Type extends AbstractNode implements Supplier<org.objectweb.asm.Type> {

    private final Optional<AST> simpleTypeOrParameterized;

    public Type(Object t) {
        this.simpleTypeOrParameterized = Optional.ofNullable((AST) t);
        addChild(simpleTypeOrParameterized);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.type(this);
    }

    @Override
    public String toString() {
        return "(Type:" + simpleTypeOrParameterized.toString() + ")";
    }

    @Override
    public org.objectweb.asm.Type get() {
        org.objectweb.asm.Type ret = simpleTypeOrParameterized.map(t -> {
            if (t instanceof Type) {
                Type t1 = (Type) t;
                return t1.get();
            } else if (t instanceof SimpleType) {
                SimpleType simpleType = (SimpleType) t;
                return simpleType.get();
            }
            return org.objectweb.asm.Type.BOOLEAN_TYPE;

        }).orElse(org.objectweb.asm.Type.getType(Object.class));
        return ret;
    }

}
