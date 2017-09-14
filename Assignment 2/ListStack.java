
public class ListStack {
	private CustomLinkedList list = new CustomLinkedList(); 
	public ListStack() {
		
	}
	public void push(int val) 
	{
		list.insertAtEnd(val);
	}
	public void pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
		}
		else
		{
			
		}
	}
	public void display() 
	{
		
		//for loop
	}
	public int getSize()
	{
		return list.getSize();
	}
	public boolean isEmpty() 
	{
		if(list.isEmpty())
		{
			return true;
		} else 
		{
			return false;
		}
	}
}
