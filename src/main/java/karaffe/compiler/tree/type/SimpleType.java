/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.type;

import java.util.function.Supplier;
import karaffe.compiler.phase.resolvers.ClassResolver;
import karaffe.compiler.tree.AST;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.visitor.Visitor;
import org.objectweb.asm.Type;

public class SimpleType extends AbstractNode implements Supplier<org.objectweb.asm.Type> {

    private final AST simpleType;

    public SimpleType(Object s) {
        this.simpleType = (AST) s;
        addChildren(simpleType);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.simpleType(this);
    }

    @Override
    public String toString() {
        return "(SimpleType:" + simpleType + ")";
    }

    @Override
    public Type get() {
        String name = TypeName.class.cast(simpleType).get();
        ClassResolver resolver = new ClassResolver();
        String[] sp = name.split("/");
        return Type.getType(resolver.resolve(sp[sp.length - 1]).orElse(Object.class));
    }
}
