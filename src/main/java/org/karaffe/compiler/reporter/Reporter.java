package org.karaffe.compiler.reporter;

import org.karaffe.compiler.io.Pos;

public enum Reporter {
    INSTANCE,;

    public void error(String message) {

    }

    public void error(String message, Pos pos) {

    }

    public void error(String message, Pos pos, Exception ex) {

    }
}
