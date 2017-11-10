import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * This class creates a circular buffer that locks when writing or reading
 * @author Minghao Shan
 * @version 11/2/2017
 */
public class CircularBuffer {
	private Lock lock = new ReentrantLock();
	private final Condition put = lock.newCondition();
	private final Condition get = lock.newCondition();
	private int numExist;
	
	private int[] circArray = new int[10];
	/**
	 * Locks the array and checks number of available elements in the array.
	 * Waits when the array is full.
	 * @param value	The value to put in the array.
	 */
	public void putNum(int value) {
		lock.lock();
		try {
			numExist=0;
			for(int i:circArray) {
				if(i!=0) {
					numExist++;
				}
			}
			while(numExist == 10) {
				put.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			for(int i:circArray) {
				if(i==0) {
					i = value;
				}
			}
			get.signal();
			lock.unlock();
		}
	}
	/**
	 * Locks the array and checks number of available elements in the array.
	 * Waits when the array is empty.
	 * @return 	The value to consume from the array.
	 */
	public int getNum(){
		System.out.println("Getting Number");
		int value = 0;
		lock.lock();
		try {
			numExist=0;
			//increase the count number for every non-zero number in the array
			for(int i:circArray) {
				if(i!=0) {
					numExist++;
				}
			}
			while(numExist == 0) {
				get.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			for(int i:circArray) {
				if(i!=0) {
					value = circArray[i];
					i = 0;
					break;
				}
			}
			put.signal();
			lock.unlock();
		}
		return value;
	}
}
