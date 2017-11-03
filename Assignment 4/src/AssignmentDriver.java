import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This program checks if the Fibonacci number is also a prime number
 * @author Minghao Shan
 * @version 11/2/2017
 */
public class AssignmentDriver {
	static int num;

	
	/**
	 * Create 3 threads that has 3 classes?
	 */
	public static void createThread() {
		
		CircularBuffer primeBuffer = new CircularBuffer();
		CircularBuffer fibonacciBuffer = new CircularBuffer();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new PrimeThread(num, primeBuffer));
		executor.execute(new FibonacciThread(num, fibonacciBuffer));
		executor.execute(new CheckThread(num, primeBuffer, fibonacciBuffer));
	}
	/**
	 * Main method
	 */
	public static void main(String args[]) {
		System.out.println("Enter the number:");
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		createThread();
	}
}
