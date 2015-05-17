/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.util;

import java.util.function.Supplier;
import karaffe.compiler.KCompiler;
import karaffe.compiler.phase.ToDo;
import org.objectweb.asm.Opcodes;

public class ModifierData implements Supplier<Integer> {

    private int acc = 0;
    private boolean isNullable = false;

    @Override
    public Integer get() {
        //何もいじられてない時にgetが呼ばれるのはおかしい
        if (acc == 0 && !isNullable) {
            throw new IllegalStateException();
        }
        return acc == 0 ? Opcodes.ACC_PUBLIC : acc;
    }

    public void add(Integer m) {
        int result = acc | m;
        if (result != acc + m) {
            KCompiler.todoList.add(new ToDo(ToDo.Type.ERROR, "修飾子が重複しています。"));
        }
        acc += m;
    }

    public void nullable() {
        isNullable = true;
    }

    public boolean isNullable() {
        return isNullable;
    }

    public ModifierData compose(ModifierData other) {
        this.add(other.get());
        if (other.isNullable) {
            this.nullable();
        }
        return this;
    }
}
