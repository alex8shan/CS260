import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * This is the thread class that checks 2 buffers and select the same number to the third arraylist 
 * @author Minghao Shan
 * @version 11/2/2017
 */
public class CheckThread implements Runnable {
	int inputNum;
	CircularBuffer primeBuffer, fibonacciBuffer;
	List<Integer> primeList;
	List<Integer> fibonacciList;
	List<Integer> resultList;
	/**
	 * This is the constructor
	 * @param num		The user inputs
	 * @param buffer1	The buffer shared with prime thread
	 * @param buffer2	The buffer shared with fibonacci thread
	 */
	public CheckThread(int num, CircularBuffer buffer1, CircularBuffer buffer2) {
		this.inputNum=num;
		primeBuffer = buffer1;
		fibonacciBuffer = buffer2;
	}
	/**
	 * This s the handler method.
	 */
	public void run() {

		primeList = new ArrayList<Integer>();
		fibonacciList = new ArrayList<Integer>();
		resultList = new ArrayList<Integer>();
		
		//for every 100 ms, compares two lists. 
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			/**
			 * This is the handler method. It is responsible for consuming both numbers annd
			 * if both arraylist have same elements and not in the result arraylist, the number
			 * will be add in the result arraylist and be printed out. If the both result is -1,
			 * meaning both threads ends, the timer will end.
			 */
			@Override
			public void run() {
				int prime = primeBuffer.getNum();
				int fibonacci = fibonacciBuffer.getNum();

				if(prime != 0 || prime != -1) {
					primeList.add(prime);
				}
				if(fibonacci != 0 || fibonacci != -1) {
					fibonacciList.add(fibonacci);
				}
				if(prime == -1) {
					timer.cancel();
				}
				for(int i : primeList) {
					for(int j : fibonacciList) {
						boolean isSame = true;
						if(i == j ) {
							for(int k : resultList) {
								if(i == k) {
									isSame = false;
								} 
							}
							if(isSame) {
								resultList.add(i);
								System.out.printf("Same: ");
								System.out.println(i);
							}
						}

					}
				}
			}
		}, 200, 200);
		System.out.printf("The numbers that is both fibonacci and prime are:");
		for(int i : resultList) {
			System.out.println(i);
		}
	}
}
