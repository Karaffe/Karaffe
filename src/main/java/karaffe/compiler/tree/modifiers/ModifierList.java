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

    private final Supplier<ModifierData> modifier;
    private final Optional<ModifierList> modifierList;

    public ModifierList(Object m, Object l) {
        this.modifier = (Supplier<ModifierData>) m;
        this.modifierList = Optional.ofNullable((ModifierList) l);
        addChildren((AST) modifier);
        addChildren(modifierList);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.modifierList(this);
    }

    @Override
    public ModifierData get() {
        ModifierData ret = new ModifierData();
        //modifierは常にあるので合成
        ret.compose(this.modifier.get());
        //ModifierListとModifierを再帰的に取得して全部合成していく
        if (hasNextModifier()) {
            ModifierList l = nextModifierList();
            ModifierData data = l.get();
            ret.compose(data);
            while (l.hasNextModifier()) {
                l = l.nextModifierList();
                ModifierData d = l.get();
                ret.compose(d);
            }
        }
        return ret;
    }

    public ModifierList nextModifierList() {
        return modifierList.get();
    }

    public boolean hasNextModifier() {
        return modifierList.isPresent();
    }
}
