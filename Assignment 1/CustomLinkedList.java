/**
 * This class implements a Singly or One Way Linked List. The options include
 * standard options, find all elements of a certain value, update certain values
 * and update values based on the positions of the list.
 * @author Minghao Shan
 * @version September 1 2017
 */

public class CustomLinkedList
{
	private Node start;
	private Node end;
	private int size;
	
	/**
	 * This is the constructor that sets everything to default value.
	 */
	public CustomLinkedList()
	{
		start = null;
		end = null;
		size = 0;
	}
	
	/**
	 * This method checks if the list is empty.
	 * @return 		true: if the list is empty, false: otherwise
	 */
	public boolean isEmpty()
	{
		if(start == null)
			return true;
		else
			return false;
	}
	
	/**
	 * This method returns the size of list.
	 * @return 		Size of the list(# of nodes)
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * This method insert a new node at the start position and assign node start to it.
	 * @param val 	The value to be inserted at the first node of the list.
	 */
	public void insertAtStart(int val)
	{
		Node node = new Node(val, null);
		size++;
		if(start == null)
		{
			start = node;
			end = start;
		}
		else
		{
			node.setNext(start);
			start = node;
		}
	}
	
	/**
	 * This method inserts a node at the end 
	 * @param val 	The value to insert at the end.
	 */
	public void insertAtEnd(int val)
	{
		Node node = new Node(val, null);
		size++;
		if(start == null)
		{
			start = node;
			end = start;
		}
		else
		{
			end.setNext(node);
			end = node;
		}
	}
	
	/**
	 * This method inserts a node at the position of choice
	 * @param val 	The value to insert
	 * @param pos 	The position wish to insert
	 */
	public void insertAtPos(int val, int pos)
	{
		//
		
		Node node = new Node(val, null);
		Node aNode = start;
		pos = pos -1;
		for (int i = 1; i < size; i++)
		{
			if(i == pos)
			{
				Node tmp = aNode.getNext();
				aNode.setNext(node);
				node.setNext(tmp);
				break;
			}
			aNode = aNode.getNext();
		}
		size++;
	}
	/**
	 * This method deletes node at position of choice
	 * @param pos 	The position where the node should be deleted
	 */
	public void deleteAtPos(int pos)
	{
		if(pos == 1)
		{
			start = start.getNext();
			size--;
			return;
		}
		if(pos == size)
		{
			Node s = start;
			Node t = start;
			while(s != end)
			{
				t = s;
				s = s.getNext();
			}
			end = t;
			end.setNext(null);
			size--;
			return;
		}
		Node aNode = start;
		pos = pos - 1;
		for(int i = 1; i < size - 1; i++)
		{
			if(i == pos)
			{
				Node tmp = aNode.getNext();
				tmp = tmp.getNext();
				aNode.setNext(tmp);
				break;
			}
		aNode = aNode.getNext();
		}
		size--;
	}
	
	/**
	 * The method that checks if certain value is in the linked list.
	 * @param val 	the value to be checked
	 * @return		-1 because position cannot be negative.
	 */
	public int findData(int val)
	{
		Node aNode = start;
		int position = 1;
		while (!(aNode==null))
		{
			if(aNode.getData()==val)
			{
				System.out.println("Found in Linkedlist");
			}
			aNode = aNode.getNext();
			position++;
		}
		return -1;
	}
	
	/**
	 * find if certain value is in the linked list.
	 * @param val 	the value to be checked
	 * @return 		an array containing positions of values occurred
	 */
	public int[] findAll(int val)
	{
		int [] positions = null;
		int arraySize = 0;
		Node aNode = start;
		
		for(int i = 1; i <= size; i++)
		{
			if(aNode.getData() == val)
			{
				arraySize++;
			}
			aNode = aNode.getNext();
		}
		
		if(arraySize ==0)
		{
			return positions;
		}
		
		positions = new int[arraySize];
		int count = 0;
		aNode = start;
		for(int i = 1; i <= size; i++)
		{
			if(aNode.getData() == val)
			{
				positions[count] = i;
				count ++;
			}
			aNode = aNode.getNext();
		}
		if(count == 0)
		{
			positions[0] = -1;
		}
		return positions;
	}
	
	/**
	 * This method updates the first value you want to change to a new value
	 * @param initialVal 	The value to be changed
	 * @param newVal 		The value that will be changed to
	 */
	public void update(int initialVal, int newVal)
	{
		Node aNode = start;

		for(int i = 1; i <= size; i++)
		{
			if(aNode.getData() == initialVal)
			{
				aNode.setData(newVal);
				break;//how do you break the for loop????
			}
			aNode = aNode.getNext();
		}
	}
	
	/**
	 * This method updates all values entered to a new value
	 * @param initialVal	The value to be changed
	 * @param newVal 		The value that will be changed to
	 */
	public void updateAll(int initialVal, int newVal)
	{
		Node aNode = start;
		
		for(int i = 1; i <= size; i++)
		{
			if(aNode.getData() == initialVal)
			{
				aNode.setData(newVal);
			}
			aNode = aNode.getNext();
		}
	}
	
	/**
	 * This method updates value at position of choice
	 * @param pos		The position where the value to be changed	
	 * @param newVal	The new value that will be changed
	 */
	public void updateAtPos(int pos, int newVal)
	{
		Node aNode = start;
		for(int i = 1; i <= size; i++) 
		{
			if (i == pos)
			{
				aNode.setData(newVal);
				break;
			}
			aNode = aNode.getNext();
		}
	}
	
	/**
	 * This method gets the first node of the list and return it
	 * @return	the start node of the list  
	 */
	public Node getStart()
	{
		return start;
	}
	
	/**
	 * This metod gets the last node of the list and return it
	 * @return	the end node of the list 
	 */
	public Node getEnd()
	{
		return end;
	}
}