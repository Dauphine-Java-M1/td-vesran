package fr.dauphine.ja.tranyves.td00;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
        this.test0isNotPrime();
        this.testTwoIsPrime();
        this.test9IsNotPrime();
    }

    public void test0isNotPrime() {
        PrimeCollection pc = new PrimeCollection();

        // 0 is not a prime number
        assertFalse(pc.isPrime(0));
    }

    public void testTwoIsPrime() {
        PrimeCollection pc = new PrimeCollection();

        assertTrue(pc.isPrime(2));
    }

    public void test9IsNotPrime() {
        PrimeCollection pc = new PrimeCollection();

        assertFalse(pc.isPrime(9));
    }
}
