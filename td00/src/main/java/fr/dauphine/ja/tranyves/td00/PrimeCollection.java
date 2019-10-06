package fr.dauphine.ja.tranyves.td00;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PrimeCollection {
	
	private List<Integer> numbers;
	
	public PrimeCollection() {
		this.numbers = new ArrayList<Integer>();
	}
	
	public void initRandom(int n, int m) {
		Random rand = new Random();
		
		for (int i = 0; i < n; i++) {
			this.numbers.add(rand.nextInt(m));
		}
	}
	
	public boolean isPrime(Integer p) {
		if (p <= 1) {
			return false;
		} 
		for (int i = 2; i <= Math.sqrt(p); i++) {
			if (p % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
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
	
    public static void main( String[] args )
    {
        PrimeCollection pc = new PrimeCollection();
        pc.initRandom(100, 1000);
        System.out.println(pc);
        
        pc.printPrime();
    }
}
