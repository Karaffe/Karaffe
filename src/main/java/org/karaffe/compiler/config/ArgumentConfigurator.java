package org.karaffe.compiler.config;

import org.karaffe.compiler.backend.KaraffeBackend;
import org.karaffe.compiler.frontend.KaraffeFrontend;
import org.karaffe.compiler.optimizer.ILOptimizer;
import org.karaffe.compiler.output.BytecodeWriter;

/**
 * generate config from compiler args
 *
 * @author noko
 */
public class ArgumentConfigurator implements CompilerConfig {

    private KaraffeFrontend frontend;
    private ILOptimizer optimizer;
    private KaraffeBackend backend;
    private BytecodeWriter writer;

    public ArgumentConfigurator(String... args) {
        if ( args == null ) {
            throw new NullPointerException("null args");
        }
        if ( args.length == 0 ) {

        }
    }

    @Override
    public KaraffeBackend getBackend() {
        return backend;
    }

    @Override
    public KaraffeFrontend getFrontend() {
        return frontend;
    }

    @Override
    public ILOptimizer getOptimizer() {
        return optimizer;
    }

    @Override
    public BytecodeWriter getWriter() {
        return writer;
    }

}
