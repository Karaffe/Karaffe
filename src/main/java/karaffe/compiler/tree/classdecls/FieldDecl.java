/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.classdecls;

import java.util.Optional;
import java.util.function.Supplier;
import karaffe.compiler.tree.AST;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.tree.Identifier;
import karaffe.compiler.tree.modifiers.ModifierList;
import karaffe.compiler.visitor.Visitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.FieldNode;

public class FieldDecl extends AbstractNode implements Supplier<FieldNode> {

    private final Optional<AST> annotationList;
    private final Optional<ModifierList> modifierList;
    private final AST identifier;
    private final karaffe.compiler.tree.type.Type type;
    private final Optional<AST> initializer;

    public FieldDecl(Object a, Object m, Object id, Object t, Object init) {
        this.annotationList = Optional.ofNullable((AST) a);
        this.modifierList = Optional.ofNullable((ModifierList) m);
        this.identifier = (AST) id;
        this.type = (karaffe.compiler.tree.type.Type) t;
        this.initializer = Optional.ofNullable((AST) init);
        addChild(annotationList);
        addChild(modifierList);
        addChild(identifier);
        addChild(type);
        addChild(initializer);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.fieldDecl(this);
    }

    public int access() {
        Integer acc
                = modifierList
                .map(modlist -> modlist.get())
                .map(modifierData -> modifierData.get())
                .orElse(Opcodes.ACC_PUBLIC);
        return acc;
    }

    public String name() {
        return Identifier.class.cast(identifier).get();
    }

    public String desc() {
        return type.get().getDescriptor();
    }

    public String signature() {
        return null;
    }

    public Object value() {
        return null;
    }

    @Override
    public String toString() {
        return "(FieldDecl:" + String.join(",", annotationList.toString(), modifierList.toString(), identifier.toString(), type.toString(), initializer.toString()) + ")";
    }

    @Override
    public FieldNode get() {
        return new FieldNode(access(), name(), desc(), signature(), value());
    }
}
