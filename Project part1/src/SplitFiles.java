import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SplitFiles {
	private static File file;
	private static Scanner in;
	private static String filePath;
	private static FileInputStream fileInput;
	private static FileOutputStream fileOutput;
	
	public static void splitFile(Path path) throws IOException
	{
		
		int size = (int) Files.size(path);
		int extraSize = size%5;
		int splitSize = size/5; 
		//the FileInputStream object
		fileInput = new FileInputStream(filePath);

			for(int i = 0; i < 5; i++)
			{
				//Create files to copy into
				file = new File(size/(1024*1024) + "Mb_" + i + ".txt");
				//the FileoutputStream object
				fileOutput = new FileOutputStream(file);
				//
				if(extraSize > 0)
				{
					for(int j = 0; j < (splitSize + 1); j++)
					{
						char data =  (char) fileInput.read();
						fileOutput.write(data);
					}
					extraSize--;
				}
				else
				{
					for(int j = 0; j < (splitSize + 1); j++)
					{
						char data =  (char) fileInput.read();
						fileOutput.write(data);
					}
				}
				System.out.println("File " + i +" has finished");
			}
		}
	
	public static void closeFile() throws IOException
	{
		fileInput.close();
		fileOutput.close();
		in.close();
		System.out.println("Program terminates");
	}
	
	public static void main(String args[])
	{
		in = new Scanner(System.in);
		System.out.println("Enter file or directory name:");
		filePath = in.nextLine();
		Path path = Paths.get(filePath);
		try {
			splitFile(path);
			closeFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
