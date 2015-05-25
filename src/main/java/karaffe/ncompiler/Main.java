/**
 * Karaffe Programming Language
 */
package karaffe.ncompiler;

import karaffe.ncompiler.input.CompilerOptions;

public class Main {

    public static void main(String[] args) {
        Compiler compiler = new DefaultComplier(new CompilerOptions(args));
        compiler.compile();
    }
}
