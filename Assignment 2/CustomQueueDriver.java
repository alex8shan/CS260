import java.util.Scanner;

public class CustomQueueDriver {
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		/* Creating objects for class linkedlist*/
		CustomQueue q = new CustomQueue();

		while(true)
		{
			System.out.println("\n Queue Options \n");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Check Empty?");
			System.out.println("4. Display");
			System.out.println("5. Peek");
			System.out.println("6. Get Size");
			System.out.println("7.exit");

			int choice = scan.nextInt();

			switch (choice)
			{
			case 1: //Enqueue
				System.out.println("Enter integer element to insert");
			}
		}
	}


}
