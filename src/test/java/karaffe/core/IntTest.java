/**
 * Karaffe Programming Language
 */
package karaffe.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author noko
 */
public class IntTest {

    @Test
    public void testEquals() {
        assertTrue(new Int(1).equals(new Int(1)));
    }

    @Test
    public void testNotEquals() {
        assertTrue(new Int(1).notEquals(new Int(2)));
        assertTrue(!new Int(1).notEquals(new Int(1)));
    }

    @Test
    public void testPlus() {
        assertTrue(new Int(2).equals(new Int(1).plus(new Int(1))));
    }

    @Test
    public void testMinus() {
        assertTrue(new Int(0).equals(new Int(1).minus(new Int(1))));
    }

    @Test
    public void testMul() {
        assertTrue(new Int(5).equals(new Int(1).mul(new Int(5))));
    }

    @Test
    public void testDiv() {
        assertTrue(new Double(1.0).equals(new Int(5).div(new Int(5))));
    }

    @Test
    public void testToInt() {
        assertTrue(new Int(1).toInt() == 1);
    }

    @Test
    public void testToLong() {
        assertTrue(new Int(1).toLong() == 1L);
    }

    @Test
    public void testToFloat() {
        assertTrue(new Int(1).toFloat() == 1f);
    }

    @Test
    public void testToDouble() {
        assertTrue(new Int(1).toDouble() == 1.0d);
    }

    @Test
    public void testLessThan() {
        assertTrue(new Int(1).lessThan(new Int(2)));
        assertFalse(new Int(1).lessThan(new Int(1)));
        assertFalse(new Int(1).lessThan(new Int(0)));
    }

    @Test
    public void testGreaterThan() {
        assertTrue(new Int(1).greaterThan(new Int(0)));
        assertFalse(new Int(1).greaterThan(new Int(1)));
        assertFalse(new Int(1).greaterThan(new Int(2)));
    }

    @Test
    public void testLessThanEqualTo() {
        assertTrue(new Int(1).lessThanEqualTo(new Int(2)));
        assertTrue(new Int(1).lessThanEqualTo(new Int(1)));
        assertFalse(new Int(1).lessThanEqualTo(new Int(0)));
    }

    @Test
    public void testGreaterThanEqualTo() {
        assertTrue(new Int(1).greaterThanEqualTo(new Int(0)));
        assertTrue(new Int(1).greaterThanEqualTo(new Int(1)));
        assertFalse(new Int(1).greaterThanEqualTo(new Int(2)));
    }

    @Test
    public void testToString() {
    }

}
