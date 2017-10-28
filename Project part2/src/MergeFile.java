import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** This part of the project is to merge 5 partitions of a file into one file, using 5 different threads.
 * 
 * @author Minghao Shan
 * @version 10/24/2017
 */
public class MergeFile {
	public static void createThreads() {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i = 1; i < 6; i++) {
			Runnable merge = new MergeThread(i);
			executor.execute(merge);
		}
	}
	//Return & Param might have to be changed
	public void readFiles() {
		
	}
	//Return & Param might have to be changed
	public void writeFiles() {
		
	}
	public static void main(String args[]) {
	//create merge file
	
	//call method that sets 5 threads
	createThreads();
		
	System.out.println("The task is finished!");
	}
}
