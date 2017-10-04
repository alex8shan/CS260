import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;



//C:\Users\FIrefly\OneDrive\Github\CS260\Assignment 3 Cryptography\input.txt

public class CipherDriver {
	private static Scanner in = new Scanner(System.in);
	private static Scanner inputReader;
	private static Scanner encryptReader;
	private String encryptedInput;
	private String decryptedInput;
	private static String output = "";
	

	public static void encrypt() throws Exception
	{
		FileWriter fWriter = new FileWriter("encrypt.txt");
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		
		while (inputReader.hasNext())
		{
			String input = inputReader.nextLine();
			for ( int i = 0; i < input.length();i++)
			{
				char inputChar = input.charAt(i);
				if(inputChar != ' ')
				{
					inputChar = (char) (inputChar + 3);
				}
				output = output + inputChar;
			}
		}
		bWriter.write(output);
		bWriter.close();
		fWriter.close();
	}
	
	public static void decrypt() throws Exception
	{
		FileWriter fWriter = new FileWriter("decrypt.txt");
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		
		while (encryptReader.hasNext())
		{
			String input = encryptReader.nextLine();
			for ( int i = 0; i < input.length();i++)
			{
				char inputChar = input.charAt(i);
				if(inputChar != ' ')
				{
					inputChar = (char) (inputChar - 3);
				}
				output = output + inputChar;
			}
		}
		bWriter.write(output);
		bWriter.close();
		fWriter.close();
	}
	
	public static void closeFile()
	{
		if(inputReader != null)
			inputReader.close();
		if(encryptReader != null)
			encryptReader.close();
	}
	
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
			//do encryption
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
			//do decryption
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
