import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * This class is 
 * @author Minghao Shan
 * @version 10/30/2017
 */
public class MergeFileThread extends Thread{
	int threadIndex;
	String fileName;
	static BufferedWriter writer;
	/**
	 * This is the constructor of MergeFileThread class.
	 * @param threadNum	The index of thread
	 * @param name		The name of the file
	 */
	public MergeFileThread(int threadNum, String name) {
		threadIndex = threadNum;
		fileName = name;
	}
	/**
	 * This is the method where the thread that reads from the file partition to the original file.
	 */
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName + "_" + Integer.toString(threadIndex) + ".txt"));
			writer = new BufferedWriter(new FileWriter(fileName + ".txt", true));
			
			//read character by character and write them
			int fileSize = (int) Files.size(Paths.get(fileName + "_" + Integer.toString(threadIndex) + ".txt"));
			for(int i = 0; i < (fileSize); i ++) {
				char data = (char) reader.read();
				writer.write(data);
			}
			reader.close();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
