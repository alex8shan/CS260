import java.util.Scanner;

/**
 * This program checks if the Fibonacci number is also a prime number
 * @author Minghao Shan
 *
 */
public class CheckNumber {
	static int num;
	static int [] primeBuffer = new int[10];
	static int [] fibonacciBuffer = new int[10];
	/**
	 * Create 3 threads that has 3 classes?
	 */
	public static void createThread() {
		PrimeThread getPrime = new PrimeThread(num);
		FibonacciThread getFibonacci = new FibonacciThread(num);
		CheckThread checkNum = new CheckThread(num);
		
		
	}
	public static void main(String args[]) {
		System.out.println("Enter the number:");
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		
		
	}
}
