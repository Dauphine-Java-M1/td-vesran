package fr.dauphine.ja.tranyves.shapes;

import fr.dauphine.ja.tranyves.shapes.model.Point;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class PointTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PointTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PointTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPoint() {
        this.testEquals();
        this.testEquals2();
    }

    public void testEquals() {
        Point p1 = new Point(1, 2);
        Point p3 = new Point(1, 2);
        assertEquals(p1, p3);
    }

    public void testEquals2() {
        Point p1 = new Point(1, 2);
        Point p2 = p1;
        Point p3 = new Point(1, 2);

        ArrayList<Point> list = new ArrayList<>();
        list.add(p1);

        assertEquals(list.indexOf(p2), 0);
        assertEquals(list.indexOf(p3), 0);
    }
}
