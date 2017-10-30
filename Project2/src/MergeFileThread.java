import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeFileThread extends Thread{
	int threadNum;
	String fileName;
	static BufferedWriter writer;
	public MergeFileThread(int thread, String name) {
		threadNum = thread;
		fileName = name;
	}

	public void run() {
		System.out.println("Thread " + threadNum + " is generated");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName + Integer.toString(threadNum) + ".txt"));
			writer = new BufferedWriter(new FileWriter(fileName + ".txt", true));
			
			//read character by character and write them
			int fileSize = (int) Files.size(Paths.get(fileName + Integer.toString(threadNum) + ".txt"));
			for(int i = 0; i < (fileSize); i ++) {
				char data = (char) reader.read();
				writer.write(data);
			}
			
			reader.close();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread " + threadNum + " is terminated");
	}
}
