package org.karaffe.compiler.optimizer;

import org.karaffe.compiler.io.KaraffeIL;

public interface ILOptimizer {

    public KaraffeIL optimize(KaraffeIL before);
}
