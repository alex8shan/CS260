import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * This is a thread class that gets the prime number and add the number to the prime buffer.
 * @author Minghao Shan
 * @version 11/2/2017
 */
public class PrimeThread implements Runnable {
	int inputNum, start, numPrime, numExist;
	boolean isPrime;
	CircularBuffer primeBuffer; 
	ReentrantLock primeLock;
	Condition primeCondition;
	/**
	 * Constructor
	 * @param num		The user inputs
	 * @param buffer	The buffer shared with prime thread
	 */
	public PrimeThread(int num, CircularBuffer buffer) {
		inputNum = num;
		primeBuffer = buffer;
	}
	/**
	 * The handler method. At the end of the method(thread), 
	 * -1 will be put into the prime buffer.
	 */
	public void run() {
		for (start = 2; start <= inputNum; start++) {
			// checks if start is a prime number
			isPrime = true;
			
			for (int i = 2; i < start; i++) {
				if (start % i == 0) {
					isPrime = false;
				}
			}
			
			if (isPrime) {
				System.out.printf("Prime: ");
				System.out.println(start);
				primeBuffer.putNum(start);
			}
		}
		primeBuffer.putNum(-1);
	}
}
