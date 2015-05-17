/**
 * Karaffe Programming Language
 */
package karaffe.compiler.tree.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.objectweb.asm.Opcodes;

public class ModifierDataTest {

    @Test
    public void testAdd() {
        ModifierData data = new ModifierData();
        data.add(Opcodes.ACC_PUBLIC);
        assertThat(data.get(), is(Opcodes.ACC_PUBLIC));
        data.add(Opcodes.ACC_ABSTRACT);
        assertThat(data.get(), is(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT));
    }

}
