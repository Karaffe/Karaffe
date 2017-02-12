package org.karaffe.compiler;

public class KaraffeCompilerException extends RuntimeException {

    private static final long serialVersionUID = 8803424038193558641L;

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
