package fr.dauphine.ja.tranyves.td00;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// import static junit.framework.Assert.assertTrue;

/**
 * Unit test for PrimeCollection class.
 */
public class PrimeCollectionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PrimeCollectionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PrimeCollectionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPrimeCollection()
    {
        assertTrue( true );
    }
}
