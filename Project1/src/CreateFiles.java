import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible of generating  files of the sizes 100M, 250M, 500M, 1G, 2G & 3G.
 * @author Minghao Shan
 * @version 10/5/2017
 */
public class CreateFiles {
	public static void createFiles(int size) throws IOException
	{
		File file = new File(size + "Mb.txt");
		FileWriter writer = new FileWriter(file);
		int iterations = size * 1024 *32;
		for(int i = 0; i < iterations; i++)
		{
			writer.write("We can make it! We can make it! ");
		}
		System.out.println(size + "Mb.txt created!");
		writer.close();
	}

	/**
	 * Main program
	 */
	
	public static void main(String args[]) {
		try {
			createFiles(100);
			//createFiles(250);
			//createFiles(500);
			//createFiles(1024);
			//createFiles(2048);
			//createFiles(3096);
		} catch (IOException e) {
			System.err.println("Error creating or writing file.");
		}
	}
}

