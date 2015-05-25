/**
 * Karaffe Programming Language
 */
package karaffe.ncompiler.input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ProgramFile {

    private final File file;
    private final List<String> source;

    public ProgramFile(File file) {
        this.file = file;
        try {
            this.source = Files.readAllLines(file.toPath());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * このファイルの指定された行を1行取り出して返す。
     * 1から始まるので0や行数以上のindexを指定した場合は{@link IndexOutOfBoundsException}をスローする。
     * @param index 取り出す行の位置
     * @return
     */
    public String getLine(int index) {
        return source.get(index - 1);
    }

}
