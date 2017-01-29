package org.karaffe.compiler.frontend;

import org.karaffe.compiler.io.KaraffeIL;
import org.karaffe.compiler.io.SourceCode;

public interface KaraffeFrontend {

    public KaraffeIL generateIL(SourceCode sourceCode);

    /**
     * Default frontend implementation.
     *
     * @return
     */
    public static KaraffeFrontend getDefault() {
        return new KaraffeBasicSourceCode();
    }
}
