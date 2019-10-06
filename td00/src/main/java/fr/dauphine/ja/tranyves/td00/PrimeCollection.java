package fr.dauphine.ja.tranyves.td00;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PrimeCollection {
	
	private List<Integer> numbers;

	/**
	 * Creates an empty list of Integer.
	 */
	public PrimeCollection() {
		this.numbers = new ArrayList<Integer>();
	}

	/**
	 * Fills the list of Integers with random Integers.
	 * @param n integer that represents the quantity of random numbers to add
	 * @param m integer that represent the upper bound of the interval [0, m] where each random number should be chosen
	 */
	public void initRandom(int n, int m) {
		Random rand = new Random();
		
		for (int i = 0; i < n; i++) {
			this.numbers.add(rand.nextInt(m));
		}
	}

	/**
	 * Checks if the given Integer is prime or not.
	 * @param p integer
	 * @return true if the the given integer is prime, false if not.
	 */
	public boolean isPrime(Integer p) {

		// If the given number is negative, equals to 0 or 1, it's not prime
		if (p <= 1) {
			return false;
		}

		// Check if there is any number that divides the given integer
		for (int i = 2; i <= Math.sqrt(p); i++) {
			if (p % i == 0) {
				return false;
			}
		}

		// No divisor has been found, the number is not prime
		return true;
	}

	/**
	 * Displays all prime numbers from the list of numbers.
	 */
	public void printPrime() {
		for (Integer nb : this.numbers) {
			if (this.isPrime(nb)) {
				System.out.println(nb);
			}
		}
	}
	
	@Override
	public String toString() {
		return this.numbers.toString();
	}
	
    public static void main( String[] args ) {
        PrimeCollection pc = new PrimeCollection();
        pc.initRandom(100, 1000);
        System.out.println(pc);
        
        pc.printPrime();
    }
}
