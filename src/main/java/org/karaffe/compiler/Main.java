package org.karaffe.compiler;

import org.karaffe.compiler.config.CompilerConfig;

public class Main {

    public static void main(String[] args) {
        Compiler compiler = Compiler.get(CompilerConfig.getDefault());
    }
}
