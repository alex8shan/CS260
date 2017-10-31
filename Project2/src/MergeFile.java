
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/** This part of the project is to merge 5 partitions of a file into one file, using 5 different threads.
 * 
 * @author Minghao Shan
 * @version 10/24/2017
 */
public class MergeFile {
	static BufferedWriter writer;
	static BufferedReader reader;
	static String fileName;
	static int fileSize;
	/**
	 * 
	 */
	public static void createThreads() {
		//create 5 threads
		MergeFileThread t0 = new MergeFileThread(0,fileName);
		MergeFileThread t1 = new MergeFileThread(1,fileName);
		MergeFileThread t2 = new MergeFileThread(2,fileName);
		MergeFileThread t3 = new MergeFileThread(3,fileName);
		MergeFileThread t4 = new MergeFileThread(4,fileName);
		
		try {
			t0.start();
			t0.join();
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
			t4.start();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the file name:");
		fileName = in.nextLine();
		//create merge file
		File mergedFile = new File(fileName + ".txt");
		try {
			if(mergedFile.createNewFile()) {
				System.out.println("File " + fileName + ".txt created!");
				//call method that starts 5 threads
				createThreads();
			} else {
				System.out.println("File is created already!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
	}
}
