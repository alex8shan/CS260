import java.util.Scanner;

public class ArrayStackDriver {
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		ArrayStack s = new ArrayStack();

		while(true)
		{
			System.out.println("\n Stack Options \n");
			System.out.println("1. Push element");
			System.out.println("2. Pop element");
			System.out.println("3. Get size");
			System.out.println("4. Display");

			int choice = scan.nextInt();

			switch (choice)
			{
			case 1: //push
				System.out.println("Enter the element to push");
				int val = scan.nextInt();
				s.push(val);
				break;
			case 2: //pop
				s.pop();
				System.out.println("Element popped");
				break;
			case 3: //getSize
				System.out.println("The size is " + s.getSize());
				break;
			case 4: //display
				s.display();
				break;
			default:
				System.out.println("wrong Entry \n");
				break;
			}
		}
	}
}