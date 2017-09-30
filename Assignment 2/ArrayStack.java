/**
 * This class implements a stack using array of 10 elements.
 * @author Minghao Shan
 * @version 9/14/2017
 */
public class ArrayStack {
	private int[] array;
	private int top;
	/**
	 * Constructor
	 */
	public ArrayStack() {
		array = new int [10];
		top = 0;
	}
	
	/**
	 * This method pushes a value in the queue.
	 * @param val	The value to be pushed into the stack
	 */
	public void push(int val) {
		if(top != 10) {
			array[top] = val;
			top++;
		} else {
			System.out.println("Stack is full!");
		}
	}
	
	/**
	 * This method pops a value out of the stack
	 */
	public void pop() {
		top--;
	}
	
	/**
	 * This method gets the size of the stack
	 * @return	size of the stack
	 */
	public int getSize() {
		return top;
	}
	/**
	 * This method displays the entire stack
	 */
	public void display() {
		System.out.println("The stack is(The latest element is at the bottom):");
		for(int i = 0; i < top; i++)
		{
			System.out.println(array[i]);
		}
	}
	/**
	 * This method determines if the stack is empty
	 * @return	true if the stack is not empty and vice versa.
	 */
	public boolean isEmpty()
	{
		if(top == 0) {
			return true;
		} else {
			return false;
		}
	}
}
