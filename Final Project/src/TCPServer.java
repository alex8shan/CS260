import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

/**
 * The TCP server will: 1. Partition the source file into 5 equal parts 2.
 * Create 5 threads and a ServerSocket in each thread 3. Each ServerSocket will
 * accept the connection from a client and will then send a partition to the
 * client
 * 
 * @author Minghao Shan
 * @version 11/22/2017
 */
public class TCPServer {
	/**
	 * Splits file into 5 parts.
	 * @param fileName File name.
	 */
	public static void splitFile(String fileName) {
		try {
			long size = (long) Files.size(Paths.get(fileName));
			System.out.println("Size is " + size);
			long extraSize = size % 5;
			long splitSize = size / 5;
			BufferedReader bReader = new BufferedReader(new FileReader(fileName));

			for (int i = 0; i < 5; i++) {
				File file = new File("part (" + i + ") " + fileName);
				BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
				if (extraSize > 0) {
					// reads a single character
					for (int j = 0; j < (splitSize + 1); j++) {
						char data = (char) bReader.read();
						bWriter.write(data);
					}
					extraSize--;
				} else {
					for (int j = 0; j < (splitSize); j++) {
						char data = (char) bReader.read();
						bWriter.write(data);
					}
				}
				bWriter.close();
				System.out.println("File part " + i + " has finished");
			}
			bReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates 5 thread and a ServerSocket in each thread
	 */
	public static void createThreads(String fileName) {
		Thread[] serverThreads = new Thread [5];
		int threadNum = 0;
		for (Thread t : serverThreads) {
			t = new Thread(new ServerThread(threadNum, fileName));
			t.start();
			threadNum ++;
		}
	}

	public static void main(String[] args) {
		long startDate = new Date().getTime();
		System.out.println("Server start at :" + startDate);
		TCPServer server = new TCPServer();
		// split the files
		server.splitFile("3096Mb.txt")	;
		// create 5 threads
		createThreads("3096Mb.txt");
	}
}
