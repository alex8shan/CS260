
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
		if(list.getStart() == null)
		{
			System.out.println("Stack is empty");
		}
		else
		{
			list.deleteAtPos(list.getSize());
		}
	}
	public void display() 
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
	public int getSize()
	{
		return list.getSize();
	}
	public boolean isEmpty() 
	{
		if(list.isEmpty())
			return true;
		else 
			return false;
	}
}
