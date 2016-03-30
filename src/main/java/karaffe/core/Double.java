package karaffe.core;

public class Double implements SimplePrimitive<Double> {

    private final double value;

    public Double(double d) {
        this.value = d;
    }

    @Override
    public boolean equals(JavaPrimitiveType that) {
        if ( that == null ) {
            return false;
        }
        return this.value == that.toDouble();
    }

    @Override
    public boolean greaterThan(Double that) {
        return this.value > that.value;
    }

    @Override
    public boolean greaterThanEqualTo(Double that) {
        return this.value >= that.value;
    }

    @Override
    public boolean lessThan(Double that) {
        return this.value < that.value;
    }

    @Override
    public boolean lessThanEqualTo(Double that) {
        return this.value <= that.value;
    }

    @Override
    public double toDouble() {
        return this.value;
    }

    @Override
    public float toFloat() {
        return (float) this.value;
    }

    @Override
    public int toInt() {
        return (int) this.value;
    }

    @Override
    public long toLong() {
        return (long) this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
