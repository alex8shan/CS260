/**
 * 
 * @author Minghao Shan
 *
 */
public class CustomQueue {
	private int[] arrayQueue;
	private int front;
	private int rear;
	/**
	 * Constructor
	 */
	public CustomQueue() {
		arrayQueue = new int[10];
		front = 0;
		rear = -1;
	}
	/**
	 * 
	 * @param val
	 */
	public void enQueue (int val)
	{
		if(rear < arrayQueue.length) {/////////////////////<= or <?
			rear++;
			arrayQueue[rear] = val;
		}else if (front != 0){
			arrayQueue[0] = val;
			rear = 0;
		}else {
			System.out.println("The queue is full, value not accepted.");
		}
	}
	/**
	 * 
	 */
	public void deQueue ()
	{
		if(isEmpty())
		{
			System.out.println("The queue is empty.");
		} else if(front == arrayQueue.length)
		{
			if(rear == arrayQueue.length - 1)
			{
				arrayQueue = new int[10];
				front = 0;
				rear = -1;
			} else 
			{
				front = 0;
			}
		} else {
			front ++;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int Peek ()
	{
		if(isEmpty())
		{
			System.out.println("The queue is empty.");//////////////////////////
			return -1;
		} else if(front == arrayQueue.length)
		{
			return arrayQueue[0];
		} else
		{
			return arrayQueue[front + 1];
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSize()
	{
		return arrayQueue.length + 1;
	}
	
	/**
	 * 
	 */
	public void display() 
	{
		if(front > rear)
		{
			for(int i = front; i < arrayQueue.length; i ++)
			{
				System.out.println(arrayQueue[i] + " -> ");
			}
			for(int j = 0; j < rear; j ++)
			{
				System.out.println(arrayQueue[j] + " -> ");
			}
			System.out.println(arrayQueue[rear]);
		} else if (front == rear)
		{
			System.out.println(front);
		}else
		{
			for (int k = front; k < rear; k++)
			{
				System.out.println(arrayQueue[k] + " -> ");
			}
			System.out.println(arrayQueue[rear]);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		if(front == 0 || rear == -1)
			return true;
		else
			return false;
	}
}
