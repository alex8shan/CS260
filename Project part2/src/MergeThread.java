
public class MergeThread implements Runnable{
	int threadNum;
	public MergeThread(int i) {
		threadNum = i;
	}
	/**
	 * This is the method that actions will be taken
	 */
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Thread " + threadNum + " started!");
		}
	}
}
