/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.modifiers;

import java.util.Optional;
import java.util.function.Supplier;
import karaffe.compiler.tree.AST;
import karaffe.compiler.tree.AbstractNode;
import karaffe.compiler.tree.util.ModifierData;
import karaffe.compiler.visitor.Visitor;

public class ModifierList extends AbstractNode implements Supplier<ModifierData> {

    private final AST modifier;
    private final Optional<AST> modifierList;

    public ModifierList(Object m, Object l) {
        this.modifier = (AST) m;
        this.modifierList = Optional.ofNullable((AST) l);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.modifierList(this);
    }

    @Override
    public ModifierData get() {
        return new ModifierData();
    }

    public AbstractModifier first() {
        return AbstractModifier.class.cast(modifier);
    }

    public Optional<AbstractModifier> nextModifier() {
        return modifierList
                .map(ModifierList.class::cast)
                .map(ModifierList::first);
    }

}
