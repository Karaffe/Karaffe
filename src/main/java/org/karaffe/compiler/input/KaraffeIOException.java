package org.karaffe.compiler.input;

import org.karaffe.compiler.KaraffeCompilerException;

public class KaraffeIOException extends KaraffeCompilerException {

    public KaraffeIOException() {
        super();
    }

    public KaraffeIOException(String message) {
        super(message);
    }

    public KaraffeIOException(Throwable t) {
        super(t);
    }

    public KaraffeIOException(String message, Throwable t) {
        super(message, t);
    }

}
