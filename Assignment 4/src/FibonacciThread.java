import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * This is a thread class that gets the fibonacci number and add the number to the fibonacci buffer.
 * @author Minghao Shan
 * @version 11/2/2017
 */
public class FibonacciThread implements Runnable {
	int inputNum, numFibonacci;
	CircularBuffer fibonacciBuffer;
	/**
	 * Constructor
	 * @param num		The user inputs
	 * @param buffer	The buffer shared with prime thread
	 */
	public FibonacciThread(int num, CircularBuffer buffer) {
		this.inputNum = num;
		fibonacciBuffer = buffer;
	}
	/**
	 * The handler method. At the end of the method(thread), 
	 * -1 will be put into the fibonacci buffer.
	 */
	public void run() {
		int a = 0;
		int b = 1;
		int i = 0;
		while(a + b<inputNum) {
			int temp = b;
			b = a + b;
			a = temp;
			i++;
			System.out.printf("Fibonacci: ");
			System.out.println(b);
			fibonacciBuffer.putNum(b);
		}
		fibonacciBuffer.putNum(-1);
	}
}
