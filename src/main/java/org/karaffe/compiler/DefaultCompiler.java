package org.karaffe.compiler;

import org.karaffe.compiler.backend.KaraffeBackend;
import org.karaffe.compiler.config.CompilerConfig;
import org.karaffe.compiler.frontend.KaraffeFrontend;
import org.karaffe.compiler.io.ByteCode;
import org.karaffe.compiler.io.KaraffeIL;
import org.karaffe.compiler.io.SourceCode;
import org.karaffe.compiler.optimizer.ILOptimizer;
import org.karaffe.compiler.output.BytecodeWriter;

public class DefaultCompiler implements Compiler {

    private final CompilerConfig config;

    public DefaultCompiler(CompilerConfig config) {
        this.config = config;

    }

    @Override
    public void compile(SourceCode sourceCode) {
        KaraffeFrontend frontend = config.getFrontend();
        KaraffeIL iL = frontend.generateIL(sourceCode);

        ILOptimizer optimizer = config.getOptimizer();
        KaraffeIL optimizedIL = optimizer.optimize(iL);

        KaraffeBackend backend = config.getBackend();
        ByteCode byteCode = backend.generateByteCode(optimizedIL);

        BytecodeWriter writer = config.getWriter();
    }

}
