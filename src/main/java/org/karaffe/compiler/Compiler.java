package org.karaffe.compiler;

import org.karaffe.compiler.config.CompilerConfig;
import org.karaffe.compiler.io.SourceCode;
import org.karaffe.compiler.io.UTF8Convertible;

public interface Compiler {

    public void compile(SourceCode sourceCode);

    public default void compile(UTF8Convertible source) {
        compile(source.toUTF8());
    }

    public static Compiler get(CompilerConfig config) {
        return new DefaultCompiler(config);
    }
}
