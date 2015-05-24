/**
 * Karaffe Programming Language
 */
package karaffe.ncompiler.input;

import java.io.File;

public class ProgramFile {

    private final File file;
    private final String source;

    public ProgramFile(File file, String source) {
        this.file = file;
        this.source = source;
    }

}
