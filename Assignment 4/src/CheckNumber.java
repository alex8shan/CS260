import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This program checks if the Fibonacci number is also a prime number
 * @author Minghao Shan
 *
 */
public class CheckNumber {
	static int num;
	
	
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
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		//executor.execute(new PrimeThread(num));
		executor.execute(new FibonacciThread(num));
		executor.execute(new CheckThread(num));
		
		
		
		System.out.println("Task finished!");
		executor.shutdown();
	}
}
