/**
 * Karaffe Programming Language
 */
package karaffe.core;

public interface SimplePrimitive<T extends JavaPrimitiveType>
    extends
    JavaPrimitiveType,
    ComparableOp<T>,
    Equals {

}
