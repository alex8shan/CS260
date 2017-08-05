import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.truman.cs260.shan.toodle.Task;


public class readFile {

	/**
	 * @param args
	 */
	static ArrayList<Task> list = new ArrayList<Task>();
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File ("Task_List.txt");
	    
		Scanner readFile = new Scanner(new File("Task_List.txt"));
		
		while(readFile.hasNextLine()){
			String data = readFile.nextLine();
			//System.out.println(data);
			System.out.println(data);
	}

}
	}
