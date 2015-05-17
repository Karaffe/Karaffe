/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.modifiers;

import java.util.function.Supplier;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.tree.util.ModifierData;
import karaffe.compiler.visitor.Visitor;
import org.objectweb.asm.Opcodes;

public class PrivateModifier extends AbstractNode implements Supplier<ModifierData> {

    @Override
    public void accept(Visitor visitor) {
        visitor.privateModifier(this);
    }

    @Override
    public ModifierData get() {
        ModifierData data = new ModifierData();
        data.add(Opcodes.ACC_PRIVATE);
        return data;
    }

}
