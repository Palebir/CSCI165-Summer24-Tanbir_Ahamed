package lab;

import static org.junit.Assert.*;
import org.junit.Test;

public class PointTest {

    @Test
    public void testDistanceFromOrigin() {
        Point p = new Point(3, 4);
        assertEquals(5.0, p.distance(), 0.0001);
    }

    private void assertEquals(double d, double distance, double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    public void testDistanceFromAnotherPoint() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);
        assertEquals(5.0, p1.distance(p2), 0.0001);
    }

    @Test
    public void testStaticDistance() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);
        assertEquals(5.0, Point.distance(p1, p2), 0.0001);
    }

    @Test
    public void testEqualsMethod() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(4, 5);
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
    }

    private void assertFalse(boolean equals) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertFalse'");
    }

    private void assertTrue(boolean equals) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }
}

