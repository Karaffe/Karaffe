package org.karaffe.compiler.backend;

import org.karaffe.compiler.io.ByteCode;
import org.karaffe.compiler.io.KaraffeIL;

public interface KaraffeBackend {

    public ByteCode generateByteCode(KaraffeIL il);
}
