/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.modifiers;

import java.util.function.Supplier;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.tree.util.ModifierData;
import karaffe.compiler.visitor.Visitor;

public class NullableModifier extends AbstractNode implements Supplier<ModifierData> {

    @Override
    public void accept(Visitor visitor) {
        visitor.nullableModifier(this);
    }

    @Override
    public ModifierData get() {
        ModifierData data = new ModifierData();
        data.nullable();
        return data;
    }

}
