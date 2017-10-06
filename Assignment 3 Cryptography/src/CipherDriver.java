import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

/**
 * This class reads from a input.txt in the same directory as the program, and encrypt it to encrypt.txt or decrypt it 
 * to decrypt.txt based on the user's choice.
 * 
 * @author Minghao Shan
 * @version 10/4/2017
 */

public class CipherDriver {
	private static Scanner in = new Scanner(System.in);
	private static Scanner inputReader;
	private static Scanner encryptReader;
	private static String output = "";
	
/**
 * 
 * @throws Exception
 */
	public static void encrypt() throws Exception
	{
		//Set the Buffered Writer to write on the encrypted file
		FileWriter fWriter = new FileWriter("encrypt.txt");
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		
		while (inputReader.hasNext())
		{
			String input = inputReader.nextLine();
			
			for ( int i = 0; i < input.length();i++)
			{
				char inputChar = input.charAt(i);
				//encryption
				if(inputChar != ' ')
				{
					inputChar = (char) (inputChar + 3);
				}
				//add encrypted character to String for output
				output = output + inputChar;
			}
		}
		bWriter.write(output);
		bWriter.close();
		fWriter.close();
	}
	/**
	 * 
	 * @throws Exception
	 */
	public static void decrypt() throws Exception
	{
		//Set the Buffered Writer to write on the decrypted file
		FileWriter fWriter = new FileWriter("decrypt.txt");
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		
		while (encryptReader.hasNext())
		{
			String input = encryptReader.nextLine();
			for ( int i = 0; i < input.length();i++)
			{
				char inputChar = input.charAt(i);
				//decryption
				if(inputChar != ' ')
				{
					inputChar = (char) (inputChar - 3);
				}
				//add decrypted character to String for output
				output = output + inputChar;
			}
		}
		bWriter.write(output);
		bWriter.close();
		fWriter.close();
	}
	/**
	 * 
	 */
	public static void closeFile()
	{
		if(inputReader != null)
			inputReader.close();
		if(encryptReader != null)
			encryptReader.close();
	}
	/**
	 * 	main program
	 */
	public static void main(String args[]) {

		try {
			inputReader = new Scanner (Paths.get("input.txt"));
			encryptReader = new Scanner (Paths.get("encrypt.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Choose 1 for encryption, 2 for decryption");
		int option = in.nextInt();
		
		if(option == 1) 
		{
			try 
			{
				encrypt();
				System.out.println("Encryption is finished");
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeFile();
		} else if (option == 2) 
		{
			try 
			{
				decrypt();
				System.out.println("Decryption is finished");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeFile();
		} else {
			System.out.println("Wrong entry \n");
		}
	}
}
