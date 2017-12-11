import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * The TCP client will: 1. Create 5 threads and a Socket object in each thread
 * 2. Each Socket object will request a connection to the corresponding Server's
 * thread 3. Once connection is established it will then accept a file partition
 * from the Server and save it onto the disk 4. Once all 5 threads are done
 * downloading: the client program will then merge these 5 downloaded partitions
 * into one file and save it onto the disk.
 *
 * @author Minghao Shan
 * @version 11/22/2017
 */
public class TCPClient {
	// 5 thread downloads files into 5 separated files.

	/**
	 * Create 5 threads and a Socket object in each thread
	 * @param fileName the file name
	 */
	public static void createThreads(String fileName) {
		Thread[] clientThreads = new Thread [5];
		int threadNum = 0;
		for (Thread t : clientThreads) {
			t = new Thread(new ClientThread(threadNum));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadNum ++;
		}
		long noMerge = new Date().getTime();
		System.out.println("Without merging, the time takes " + noMerge);
		mergeFile(fileName);
		long withMerge = new Date().getTime();
		System.out.println("With merging, the time takes " + withMerge);
	}

	/**
	 * Merges the files into 1 piece and delete the partition files.
	 * @param fileName the name of file.
	 */
	public static void mergeFile(String fileName) {
		BufferedWriter writer;

		try{
			File file = new File(fileName);
			if(!file.exists()) file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file, false));

			for(int i = 0; i < 5 ; i ++) {
				BufferedReader reader = new BufferedReader(new FileReader("part (" + i + ") " + fileName));

				//read character by character and write them
				int fileSize = (int) Files.size(Paths.get("part (" + i + ") " + fileName));
				for(int j = 0; j < (fileSize); j ++) {
					char data = (char) reader.read();
					writer.write(data);
				}
				reader.close();
			}
			writer.close();
			for(int i = 0; i < 5; i++){
				File reader = new File("part (" + i + ") " + fileName);
				reader.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fileName = "3096Mb.txt";
		System.out.println("Client start!");
		createThreads(fileName);

	}
}
