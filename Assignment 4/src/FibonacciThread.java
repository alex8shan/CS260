import java.util.concurrent.locks.Condition;

public class FibonacciThread implements Runnable {
	int inputNum, numFibonacci;
	static int [] fibonacciBuffer = new int[10];
	static Condition fibonacciCondition = CheckThread.lock.newCondition();
	
	public FibonacciThread(int num) {
		this.inputNum = num;
	}
	public void run() {
		int a = 0;
		int b = 1;
		int i = 0;
		while(a + b<inputNum) {
			fibonacciBuffer[i] = b;
			int temp = b;
			b = a + b;
			a = temp;
			i++;
			System.out.printf("Fibonacci: ");
			System.out.println(b);
			//increase the number of fibonacci
			numFibonacci++;
			// store Fibonacci into array.
			fibonacciBuffer[numFibonacci % 10] = b;
			if(fibonacciBuffer[0] != 0) {
				PrimeThread.primeCondition.signal();
				while (PrimeThread.primeBuffer[0] == 0) {
					try {
						fibonacciCondition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
	}
	public boolean isFibonacci() {
		return false;
	}
}
