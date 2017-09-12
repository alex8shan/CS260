import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is the driver for Single Linked List.
 * @author Minghao Shan
 * @version Sepetember 1 2017
 */

public class LinkedListDriver {
	/**
	 * main method
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int iniVal;
    	int newVal;
		/*Creating object of class linkedList. */
		CustomLinkedList list = new CustomLinkedList();
		System.out.println("My Linked List");
     
		/* Perform list operations*/
		while(true)
		{
			System.out.println("\n Singly Linked List Options \n");
			System.out.println("1. insert at begining");
			System.out.println("2. insert at end");
			System.out.println("3. insert at position");
			System.out.println("4. delete at position");
			System.out.println("5. check empty");
			System.out.println("6. get size");
			System.out.println("7. find all possible position");
			System.out.println("8. update the first match");
			System.out.println("9. update all");
			System.out.println("10. update certain position");
			System.out.println("11. exit");
			int choice = scan.nextInt();
			switch (choice)
			{
	        case 1://insert at beginning
	        	System.out.println("Enter integer element to insert");
	        	list.insertAtStart( scan.nextInt() );
	        	break;
	        	
	        case 2://insert at end 
	        	System.out.println("Enter integer element to insert");
	        	list.insertAtEnd( scan.nextInt() );
	        	break;
	        	
	        case 3://insert at position
	        	System.out.println("Enter integer element to insert");
	        	int num = scan.nextInt();
	        	System.out.println("Enter position");
	        	int pos = scan.nextInt();
	        	if(pos <= 1 || pos > list.getSize())
	        		System.out.println("Invalid position\n");
	        	else
	        		list.insertAtPos(num, pos);
	        	break;
	        	
	        case 4://delete at position
	        	System.out.println("Enter position");
	        	int p = scan.nextInt();
	        	if(p < 1 || p > list.getSize())
	        		System.out.println("invalid position \n");
	        	else
	        		list.deleteAtPos(p);
	        	break;
	        	
	        case 5://check empty
	        	System.out.println("Empty status = " + list.isEmpty());
	        	break;
	        	
	        case 6://get size
	        	System.out.println("Size = " + list.getSize() + "\n");
	        	break;
	        	
	        case 7://find position of all integers entered.
	        	System.out.println("Enter integer you would like to find");
	        	int val = scan.nextInt();
	    		if(list.findAll(val) == null)
	    			System.out.println("Value does not exist in the list");
	    		else 
	    			System.out.print("Value " + val + " is found in position ");
	    			for(int i = 0; i <= list.findAll(val).length - 1; i++)
	    			{
	    				System.out.print(list.findAll(val)[i] + " ");
	    			}
	    			System.out.println(' ');
	        	break;
	        	
	        case 8://updates first occurrence of integer val
	        	System.out.println("Enter the value you want to change from:");
	        	iniVal = scan.nextInt();
	        	System.out.println("Enter the value you want to change to:");
	        	newVal = scan.nextInt();
	        	list.update(iniVal, newVal);
	        	System.out.println("Successfully update first " + iniVal + " to " + newVal);
	        	break;
	        	
	        case 9://updates all values 
	        	System.out.println("Enter the value you want to change from:");
	        	iniVal = scan.nextInt();
	        	System.out.println("Enter the value you want to change to:");
	        	newVal = scan.nextInt();
	        	list.updateAll(iniVal, newVal);
	        	System.out.println("Successfully update all " + iniVal + " to " + newVal);
	        	break;
	        	
	        case 10://change the value at certain position 
	        	System.out.println("Enter the position you want to change from(start with 1):");
	        	int posVal = scan.nextInt();
	        	System.out.println("Enter the value you want to change:");
	        	int updatedVal = scan.nextInt();
	        	list.updateAtPos(posVal, updatedVal);
	        	System.out.println("Successfully update position " + posVal + " to value " + updatedVal);
	        	break;
	        	
	        case 11://terminate
	        	scan.close();
	        	System.exit(0);
	        	break;
	        	
	        default:
	        	System.out.println("Wrong Entry\n");
	        	break;
			}
			/* Display LIst */
			LinkedListDriver.display(list);
		}
	}
	
	/*Function to display elements of the linked list*/
	public static void display(CustomLinkedList list)
	{
		Node start = list.getStart();
		System.out.print("\nLinked List = ");
		if(list.getSize() == 0)
		{
			System.out.print("empty\n");
			return;
		}
		if(start.getNext() == null)
		{
			System.out.println(start.getData() );
			return;
		}
		Node aNode = start;
		System.out.print(start.getData() + "->");
		aNode = start.getNext();
		while(aNode.getNext() != null)
		{
			System.out.print(aNode.getData() + "->");
			aNode = aNode.getNext();
		}
		System.out.print(aNode.getData() + "\n");
	}
}