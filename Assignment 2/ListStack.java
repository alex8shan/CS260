/**
 * This class implements a stack using singly linked list.
 * @author Minghao Shan
 * @version 9/14/2017
 */
public class ListStack {
	private CustomLinkedList list;
	
	/**
	 * Constructor
	 */
	public ListStack() {
		list  = new CustomLinkedList();
	}
	
	/**
	 * This method pushes a value in the queue.
	 * @param val	The value to be pushed into the stack
	 */
	public void push(int val) 
	{
		list.insertAtEnd(val);
	}
	
	/**
	 * This method pops a value out of the stack
	 */
	public void pop()
	{
			list.deleteAtPos(list.getSize());
	}
	
	/**
	 * This method displays the entire stack
	 */
	public void display() 
	{
		Node start = list.getStart();
		System.out.print("\n Stack is ");
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
	
	/**
	 * This method gets the size of the stack
	 * @return	size of the stack
	 */
	public int getSize()
	{
		return list.getSize();
	}
	
	/**
	 * This method determines if the stack is empty
	 * @return	true if the stack is not empty and vice versa.
	 */
	public boolean isEmpty() 
	{
		if(list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
