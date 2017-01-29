package org.karaffe.compiler.input;

import org.karaffe.compiler.io.SourceCode;

public interface KaraffeInput {

    public SourceCode read();

    public static KaraffeInput getDefault() {
        return new StdInInput();
    }
}
