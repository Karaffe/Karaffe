/**
 * Karaffe Programming Language
 */
package karaffe.ncompiler.util;

public interface Todo {

    public int line();

    public int column();

    public String message();

    public TodoType type();

}
