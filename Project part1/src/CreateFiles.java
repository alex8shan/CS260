import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible of generating  files of the sizes 100M, 250M, 500M, 1G, 2G & 3G.
 * @author Minghao Shan
 *
 */
public class CreateFiles {
	public static void createFiles(int size) throws IOException
	{
		File file = new File(size + "Mb.txt");
		FileWriter writer = new FileWriter(file);
		int iterations = size * 1024 *64;
		for(int i = 0; i < iterations; i++)
		{
			writer.write("We can make it! ");
		}
	}
	
	public static void closeFiles()
	{
		
	}
	
	public static void main(String args[]) {
		try {
			createFiles(100);
//			createFiles(200);
//			createFiles(500);
//			createFiles(1024);
//			createFiles(2048);
//			createFiles(3096);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeFiles();
	}
}

