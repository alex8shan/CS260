/**
 * 
 * @author Minghao Shan
 *
 */
public class CustomQueue {
	private int[] arrayQueue;
	private int front;
	private int rear;
	private int size;
	/**
	 * Constructor
	 */
	public CustomQueue() {
		arrayQueue = new int[10];
		front = 0;
		rear = 0;
	}
	/**
	 * 
	 * @param val
	 */
	public void enqueue (int val)
	{
		size++;
		if(size > 10)
		{
			size = 10;
		}
		if(rear < arrayQueue.length) {
			arrayQueue[rear] = val;
			rear++;
		} else {
			System.out.println("The queue is full, value not accepted.");
		}
	}
	/**
	 * 
	 */
	public void dequeue ()
	{

		if(isEmpty())
		{
			System.out.println("The queue is empty.");
		} else if(front == arrayQueue.length)
		{
			if(size == 1)
			{
				arrayQueue = new int[10];
				front = 0;
				rear = 0;
				size--;
			} else 
			{
				front = 0;
				size--;
			}
		} else {
			if(size == 1)
			{
				arrayQueue = new int[10];
				front = 0;
				rear = 0;
				size--;
			} else 
			{
				front ++;
				size--;
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int peek ()
	{
		if(isEmpty())
		{
			return -1;
		} else if(front == arrayQueue.length)
		{
			return arrayQueue[0];
		} else
		{
			return arrayQueue[front];
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSize()
	{ 
		return size;
	}
	
	/**
	 * 
	 */
	public void display() 
	{
		System.out.println("front " + front);
		System.out.println("rear " + rear);
		if(front > rear)
		{
			for(int i = front; i < arrayQueue.length; i ++)
			{
				System.out.print(arrayQueue[i] + " -> ");
			}
			for(int j = 0; j < rear; j ++)
			{
				System.out.print(arrayQueue[j] + " -> ");
			}
			System.out.println(arrayQueue[rear]);
		} else if (front == rear)
		{
			System.out.println(front);
		} else
		{
			for (int k = front; k < rear - 1; k++)
			{
				System.out.print(arrayQueue[k] + " -> ");
			}
			System.out.println(arrayQueue[rear -1]);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		if(front == 0 && rear == 0)
		{
			System.out.println("empty");
			return true;
		}
		else
			return false;
	}
}
