import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

public class CheckThread implements Runnable {
	int inputNum;
	List<Integer> primeList;
	List<Integer> fibonacciList;
	List<Integer> resultList;
	static ReentrantLock lock = new ReentrantLock();
	public CheckThread(int num) {
		this.inputNum=num;
	}
	public void run() {
		int listIndex;
		primeList = new ArrayList<Integer>();
		fibonacciList = new ArrayList<Integer>();
		//PrimeThread.primeBuffer
		
		//FibonacciThread.fibonacciBuffer
		
		//read & delete two list
        lock.lock();
        try {
        	for(int i = 0; i < 10; i++) {
    			primeList.add(PrimeThread.primeBuffer[i]);
    			fibonacciList.add(FibonacciThread.fibonacciBuffer[i]);
    			PrimeThread.primeBuffer[i] = 0;
    			FibonacciThread.fibonacciBuffer[i] = 0;
    		}
        } finally {
            lock.unlock();
        }
		
		//for every 100 ms, compares two lists. 
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				for(int i : primeList) {
					///////////////////System.out.println(primeList.get(i));
				}
				//add the same number to resultList
			}	
			//if both threads dies, timer.cancel();
		}, 200, 200);
		 	 
		//call other threads
	}
}
