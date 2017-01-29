package org.karaffe.compiler;

public class KaraffeCompilerException extends RuntimeException {

    public KaraffeCompilerException() {
        super();
    }

    public KaraffeCompilerException(String message) {
        super(message);
    }

    public KaraffeCompilerException(Throwable t) {
        super(t);
    }

    public KaraffeCompilerException(String message, Throwable t) {
        super(message, t);
    }
}
