package karaffe.core;

public interface ComparableOp<T extends JavaPrimitiveType> {

    public boolean lessThan(T that);

    public boolean greaterThan(T that);

    public boolean lessThanEqualTo(T that);

    public boolean greaterThanEqualTo(T that);
}
