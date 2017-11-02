
public class PrimeThread extends Thread {
	int inputNum;
	int primeNum;
	boolean isPrime;
	static int [] primeBuffer = new int[10];
	public PrimeThread(int num) {
		this.inputNum = num;
	}
	public void run() {
		for(int i = 2; i <= inputNum; i++) {
			for(int j = 2; j < i; j++) {
					isPrime = false;
				if(i%j==0) {
					isPrime = true;
				}
				if(!isPrime) {
					//store prime into array.
					System.out.println(i);
				}
			}
			if(primeBuffer[i%10] == -1) {
				primeBuffer[i%10] = primeNum;
			}
		}
	}
}


//produce t item

//consume t items and get into list

//check every second

