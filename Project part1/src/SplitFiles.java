import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class let the user choose a file in the same directory as the program, then splits it into 5 files.
 * @author Minghao Shan
 * @version 10/5/2017
 */
public class SplitFiles {
	private static File file;
	private static String filePath;

	/**
	 * This program splits the selected file to 
	 * @param path The path where the file is copied from
	 * @throws IOException Input/Output errors
	 */
	public static void splitFile(Path path) throws IOException
	{
		int size = (int) Files.size(path);
		int extraSize = size%5;
		int splitSize = size/5; 
		BufferedReader bReader = new BufferedReader(new FileReader(filePath));

		for(int i = 0; i < 5; i++)
		{
			file = new File(size/(1024*1024) + "Mb_" + i + ".txt");
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
			if(extraSize > 0)
			{
				//reads a single character
				for(int j = 0; j < (splitSize + 1); j++)
				{
					char data = (char) bReader.read();
					bWriter.write(data);
				}
				extraSize--;
			}
			else
			{
				for(int j = 0; j < (splitSize); j++)
				{
					char data = (char) bReader.read();
					bWriter.write(data);
				}
			}
			bWriter.close();
			System.out.println("File " + i +" has finished");
		}
		bReader.close();
	}
	
	/**
	 * Main program
	 */
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter file or directory name:");
		filePath = in.nextLine();
		Path path = Paths.get(filePath);
		try {
			Scanner readFile = new Scanner(path);
			splitFile(path);
			in.close();
			readFile.close();
		} catch (IOException e1) {
			System.err.println("Error opening, reading or writing the file.");
		}
		System.out.println("Program terminates");
	}
}
