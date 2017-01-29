package org.karaffe.compiler.io;

import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.List;

public class SourceCode {

    private final String fileName;
    private final String sourceCode;
    private final List<String> sourceLines;

    public SourceCode(String fileName, String sourceCode) {
        this.fileName = fileName;
        this.sourceCode = sourceCode;
        this.sourceLines = Arrays.asList(sourceCode.split(System.lineSeparator()));
    }

    public SourceCode(String fileName, CharSequence seq) {
        this(fileName, seq.toString());
    }

    public String getFileName() {
        return fileName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public String get(Pos position) {
        {//@require
            assert position != null : "null position";
            assert sourceLines.size() > position.getLine() : "";
            assert position.getLine() > 0 : "line must be positive";
        }
        String line = sourceLines.get(position.getLine() - 1);
        return line;
    }

    @Override

    public String toString() {
        return sourceCode;
    }

}
