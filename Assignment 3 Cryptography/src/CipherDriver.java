import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class CipherDriver {
	private static Scanner in = new Scanner(System.in);
	private static Scanner fileReader = new Scanner(System.in);
	
	public static void openFile(Path filePath)
	{
		//open files
		//What should "file.txt" be?
		try
		{
			fileReader = new Scanner(filePath);
		}
		catch (IOException ioException)
		{
			System.out.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void Encrypt()
	{
		try
		{
			while(fileReader.hasNext())
			{
				//change the info, or read into buffer
				
			}
		}
		catch(NoSuchElementException elementException)
		{
			System.err.println("File improperly formed. Terminiting.");
		}
		catch(IllegalStateException stateException)
		{
			System.err.println("Error reading from file. Terminating.");
		}
	}
	
	public static void Decrypt()
	{
		try
		{
			while(fileReader.hasNext())
			{
				//change the info, or read into buffer
				
			}
		}
		catch(NoSuchElementException elementException)
		{
			System.err.println("File improperly formed. Terminiting.");
		}
		catch(IllegalStateException stateException)
		{
			System.err.println("Error reading from file. Terminating.");
		}
	}
	
	public static void closeFile()
	{
		if(fileReader != null)
			fileReader.close();
	}
	
	public static void main(String args[]) {

		
		System.out.println("Enter file or directory name");
		
		//create Path object based on user input
		
		Path path = Paths.get(in.nextLine());

		
		openFile(path);
		
		System.out.println("Choose 1 for Encryption, 2 for Decryption");
		int option = in.nextInt();
		
		if(option == 1) {
			//do encryption
			Encrypt();
			closeFile();
		} else if (option == 2) {
			//do decryption
			Decrypt();
			closeFile();
		} else {
			System.out.println("Wrong entry \n");
		}
	}
}
