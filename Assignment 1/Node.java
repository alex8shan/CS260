/**
 * This class implements the NODE of a one way linked list
 * 
 * @author Minghao Shan
 * @version Sepetember 1 2017
 */

public class Node
{
	private int data;
	private Node next;


	/** 
	 * This is a 0 argument constructor that sets the default value.
	 */
	public Node()
	{
		next = null;
		data = 0;
	}


	/**
	 * This is a 2 argument constructor that sets node according to the parameters.
	 * @param d	The value that will be set to 
	 * @param n	The node that current node will be pointing to next.
	 */
	public Node(int d, Node n)
	{
		data = d;
		next = n;
	}

	/**
	 * This method points current node's reference to the next Node
	 * @param n	The Node that current node will be pointing to next.
	 */
	public void setNext(Node n)
	{
		next = n;
	}


	/**
	 * This method sets current node's data
	 * @param d	The integer to be changed
	 */
	public void setData(int d)
	{
		data = d;
	}

	/**
	 * This method gets the next node that current node points to
	 * @return	Next node current node is pointing to
	 */
	public Node getNext()
	{
		return next;
	}

	/**
	 * This method gets the value stored in the current node
	 * @return	Value store in current node.
	 */
	public int getData()
	{
		return data;
	}
}