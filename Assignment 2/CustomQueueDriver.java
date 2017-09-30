import java.util.Scanner;
/**
 * This is the driver class for queue implemented by arrays.
 * @author Minghao Shan
 * @version 9/14/2017
 */
public class CustomQueueDriver {
/**
 * driver method 
 * @param args	Stores the terminal input
 */
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		CustomQueue q = new CustomQueue();

		while(true)
		{
			System.out.println("\n Queue Options \n");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Check Empty");
			System.out.println("4. Display");
			System.out.println("5. Peek");
			System.out.println("6. Get Size");
			System.out.println("7.exit");

			int choice = scan.nextInt();

			switch (choice)
			{
			case 1: //Enqueue
				System.out.println("Enter integer element to insert");
				q.enqueue(scan.nextInt());
				break;
			case 2:
				q.dequeue();
				break;
			case 3:
				System.out.println(q.isEmpty()?"Empty":"Not Empty");
				break;
			case 4:
				q.display();
				break;
			case 5:
				if(q.peek() == -1) {
					System.out.println("The queue is empty");
				} else {
					System.out.println("The next element is " + q.peek());
				}
				break;
			case 6:
				System.out.println("Size is " + q.getSize());
				break;
			case 7:
				scan.close();
				System.exit(0);
			default:
				System.out.println("wrong Entry \n");
				break;
			}
		}
	}
}
