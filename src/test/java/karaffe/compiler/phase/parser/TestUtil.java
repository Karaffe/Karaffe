/**
 * Karaffe Programming Language
 */
package karaffe.compiler.phase.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.function.Function;
import karaffe.compiler.tree.AST;
import karaffe.compiler.tree.ErrorNode;
import karaffe.compiler.tree.compileunits.CompileUnit;
import karaffe.compiler.visitor.VisitorAdaptor;
import static org.junit.Assert.fail;

public class TestUtil {

    public static CompileUnit testCode(String code) {
        try {
            Optional<AST> maybeCompileUnit = testCodeWithoutErrorCheck(code);
            AST compileUnit = maybeCompileUnit.orElseThrow(AssertionError::new);
            compileUnit.accept(new VisitorAdaptor() {

                @Override
                public void errorNode(ErrorNode aThis) {
                    if (aThis == null) {
                        fail();
                        return;
                    }
                    fail(aThis.toString());
                }

            });
            return (CompileUnit) compileUnit;
        } catch (Throwable e) {
            e.printStackTrace();
            fail(e.toString());
            return null; //unreachable stmt
        }
    }

    public static Optional<AST> testCodeWithoutErrorCheck(String code) {
        try {
            File file = File.createTempFile("krf", "");
            Files.write(file.toPath(), code.getBytes(), StandardOpenOption.APPEND);
            Parser parser = new Parser(new Lexer(new FileReader(file)));
            parser.setPath(file.getAbsolutePath());
            try {
                AST compileUnit = parser.compileUnit();
                return Optional.of(compileUnit);
            } catch (Exception e) {
                e.printStackTrace();
                return Optional.empty();
            }
        } catch (IOException ex) {
            return Optional.empty();
        }
    }

    public void assertOutput(Function function, String output) {

    }
}
