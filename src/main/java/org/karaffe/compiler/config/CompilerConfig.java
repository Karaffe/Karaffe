package org.karaffe.compiler.config;

import org.karaffe.compiler.backend.KaraffeBackend;
import org.karaffe.compiler.frontend.KaraffeFrontend;
import org.karaffe.compiler.optimizer.ILOptimizer;
import org.karaffe.compiler.output.BytecodeWriter;

public interface CompilerConfig {

    public KaraffeFrontend getFrontend();

    public ILOptimizer getOptimizer();

    public KaraffeBackend getBackend();

    public BytecodeWriter getWriter();

    public static CompilerConfig getDefault() {
        return new ArgumentConfigurator();
    }
}
