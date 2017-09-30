import java.util.Scanner;
/**
 * This class is the driver class for stack implemented by linked list.
 * @author Minghao Shan
 * @version 9/14/2017
 */
public class ListStackDriver {
	/**
	 * driver method 
	 * @param args	Stores the terminal input
	 */
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		
		ListStack s = new ListStack();

		while(true)
		{
			System.out.println("\n Stack Options \n");
			System.out.println("1. Push element");
			System.out.println("2. Pop element");
			System.out.println("3. Get size");
			System.out.println("4. Display");
			System.out.println("5. Check Empty");
			System.out.println("6. Exit");

			int choice = scan.nextInt();

			switch (choice)
			{
			case 1: //push
				System.out.println("Enter the element to push");
				int val = scan.nextInt();
				s.push(val);
				break;
			case 2: //pop
				if(s.isEmpty()) {
					System.out.println("Stack is empty");
				} else {
					s.pop();
					System.out.println("Element popped");
				}
				break;
			case 3: //getSize
				System.out.println("The size is " + s.getSize());
				break;
			case 4: //display
				s.display();
				break;
			case 5:
				System.out.println(s.isEmpty()?"Empty":"Not Empty");
				break;
			case 6:
				scan.close();
				System.exit(0);
			default:
				System.out.println("wrong Entry \n");
				break;
			}
		}
	}
}