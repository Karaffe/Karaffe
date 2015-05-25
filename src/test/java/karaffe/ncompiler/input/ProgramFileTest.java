/**
 * Karaffe Programming Language
 */
package karaffe.ncompiler.input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ProgramFileTest {

    private final ProgramFile programFile;

    public ProgramFileTest() throws IOException {
        File file = File.createTempFile("test", "");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("hoge\nfuga\npiyo");
        }
        programFile = new ProgramFile(file);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLine0() throws IOException {
        programFile.getLine(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLine4() throws IOException {
        programFile.getLine(4); //3行しかないので4番目でIndexOutOfBoundsExceptionがスローされるべき
    }

    public void testGetLine1() {
        assertThat(programFile.getLine(1), is("hoge"));
    }
}
