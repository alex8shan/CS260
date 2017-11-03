import java.util.concurrent.locks.Condition;

public class PrimeThread implements Runnable {
	int inputNum, start, numPrime;
	boolean isPrime;
	static int[] primeBuffer = new int[10]; 
	static Condition primeCondition = CheckThread.lock.newCondition();

	public PrimeThread(int num) {
		this.inputNum = num;
	}

	public void run() {
		for (start = 2; start <= inputNum; start++) {
			// checks if start is a prime number
			isPrime = true;
			for (int i = 2; 2*i < start; i++) {
				if (start % i == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.printf("Prime: ");
				System.out.println(start);
				// increase total number of prime number
				numPrime++;
				// store prime into array.
				primeBuffer[numPrime % 10] = start;
				if(primeBuffer[0] != 0) {
					while (FibonacciThread.fibonacciBuffer[0] == 0) {
						try {
							primeCondition.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
		}
	}
}
