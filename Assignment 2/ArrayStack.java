
public class ArrayStack {
	private int[] array;
	private int top;
	
	public ArrayStack() {
		array = new int [10];
		top = 0;
	}
	public void push(int val) {
		if(top != 10) {
			array[top] = val;
			top++;
		} else 
		{
			System.out.println("Stack is full!");
		}

	}
	public void pop() {
		if(isEmpty())
			System.out.println("Stack is empty");
		else
		top--;
	}
	public int getSize() {
		return top;
	}
	public void display() {
		System.out.println("The stack is(The latest element is at the bottom):");
		for(int i = 0; i < top; i++)
		{
			System.out.println(array[i]);
		}
	}
	public boolean isEmpty()
	{
		if(top == 0)
			return true;
		else
			return false;
	}
}
