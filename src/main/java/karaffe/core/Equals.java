package karaffe.core;

public interface Equals {

    public default boolean equals(JavaPrimitiveType that) {
        return !notEquals(that);
    }

    public default boolean notEquals(JavaPrimitiveType that) {
        return !equals(that);
    }
}
