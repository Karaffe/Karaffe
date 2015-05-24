/**
 * Karaffe Programming Language
 */
package karaffe.ncompiler;

public class Main {

    public static void main(String[] args) {
        Compiler compiler = new DefaultComplier(args);
        compiler.compile();
    }
}
