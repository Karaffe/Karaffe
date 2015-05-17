/**
 * Karaffe Programming Language
 */
package karaffe.compiler.phase.parser;

import java.util.List;
import static karaffe.compiler.phase.parser.TestUtil.testCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

public class ClassDeclTest {

    @Test
    public void testSimpleClassDecl() {
        testCode("class Identifier {\n"
                + "}");
    }

    @Test
    public void testSimpleClassDeclPublicModifier() {
        testCode("public class Id {}");
    }

    @Test
    public void testSimpleClassDeclPrivateModifier() {
        testCode("private class Id {}");
    }

    @Test
    public void testSimpleClassDeclAbstractModifier() {
        testCode("abstract class Id {}");
    }

    @Test
    public void testSimpleClassDeclFinalModifier() {
        List<ClassNode> classNodes = testCode("final class Id {}").getClassDeclList().get();
        assertThat(classNodes.get(0).access, is(Opcodes.ACC_FINAL));
    }

    @Test
    public void testSimpleClassDeclPublicAbstractModifier() {
        List<ClassNode> classNodes = testCode("public abstract class Id {}").getClassDeclList().get();
        assertThat(classNodes.get(0).access, is(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT));
    }

    @Test
    public void testSimpleClassDeclWithFieldDecl() {
        testCode("class Id {\n"
                + "def id = hoge\n"
                + "\n}");
    }

    @Test
    public void testFieldDeclPrivate() {
        testCode("class Id {\n"
                + "private def hoge = hoge"
                + "}\n");
    }

    @Test
    public void testFieldDeclPublic() {
        testCode("class Id {\n"
                + "public def hoge = hoge"
                + "}\n");
    }

    @Test
    public void testFieldDeclFinal() {
        testCode("class Id {\n"
                + "final def hoge = hoge"
                + "}\n");
    }

    @Test
    public void testFieldDeclStatic() {
        testCode("class Id {\n"
                + "static def hoge = hoge"
                + "}\n");
    }

    @Test
    public void testFieldDeclNullable() {
        testCode("class Id {\n"
                + "nullable def hoge = hoge"
                + "}\n");
    }

    @Test
    public void testFieldDeclPublicStaticFinal() {
        testCode("class Id {\n"
                + "public static final def hoge = hoge"
                + "}\n");
    }

    @Test
    public void testEmptyAutoDecl() {
        testCode("class User(){}");
    }

    @Test
    public void testAutoDecl() {
        testCode("class User(name String, age Int) {"
                + ""
                + "}");
    }

    @Test
    public void testExtendsOrImplements() {
        testCode("class User < java.io.Serializable {}");
    }

}
