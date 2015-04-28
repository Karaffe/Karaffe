/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.modifiers;

import java.util.function.Supplier;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.visitor.Visitor;
import org.objectweb.asm.Opcodes;

public class StaticModifier extends AbstractNode implements Supplier<Integer> {

    @Override
    public void accept(Visitor visitor) {
        visitor.staticModifier(this);
    }

    @Override
    public Integer get() {
        return Opcodes.ACC_STATIC;
    }

}
