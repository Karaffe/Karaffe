package org.karaffe.compiler.output;

import org.karaffe.compiler.io.ByteCode;

public interface BytecodeWriter {

    public void write(ByteCode byteCode);
}
