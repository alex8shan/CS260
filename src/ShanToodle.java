import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import edu.truman.cs260.shan.toodle.*;	

public class ShanToodle {
	static ArrayList<Task> list = new ArrayList<Task>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int command = 0;

		loadSession();
		while (command != 7){
			System.out.println("Please enter a command (1-7):");
			Scanner in = new Scanner(System.in);
			command = in.nextInt();
			switch(command){
				case 1:
					//task1 create new task
					createTask();
					break;
				case 2:
					//task2 print incomplete task
					printUnfinishTask();
					break;
				case 3:
					//task3 print incomplete task with priority
					getUnfinishTaskByPriority();
					break;
				case 4:
					//task4 print all tasks
					getAllTasks();
					break;
				case 5:
					//task5 mark task as complete
					System.out.println("Please enter the ID of the task: ");
					int idNum = in.nextInt();
					for(int i = 0; i < list.size(); i++){
						if(list.get(i).getId() == idNum){
							list.get(i).setComplete();
						}
					}
					break;
					
				case 6:
					//task6 mark task as cancelled
					System.out.println("Please enter the ID of the task: ");
					idNum = in.nextInt();
					break;
					//String reason = task.makeCancelled();
					
				case 7:
					//task7 quit
					exitProgram(); 
					break;				
			}
		}
	}
	
	
	public static void loadSession(){
		
		try{
			//File file = new File ("src/Task_List.txt");
		    
			Scanner readFile = new Scanner(new File("src/Task_List.txt"));
			
			while(readFile.hasNextLine()){
				String data = readFile.nextLine();
				list.add(new Task(data));
				//System.out.println(""+ list.get(0).getId() + list.get(0).getDescription() + list.get(0).getPriority() + list.get(0).getOrder()+list.get(0).getIsComplete() + list.get(0).getIsCancelled() + list.get(0).getExtraInfo());
			}
			readFile.close();
		}
		catch(Exception e)
		{
			System.err.format("Exception occurred trying to read '%s'.", "Task_list.txt");
		    e.printStackTrace();
		}
		
	}
	public static void createTask(){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the description of the task: ");
		String description = in.nextLine();
		System.out.println("Please enter the priority of the task: ");
		char priority = in.next().charAt(0);
		System.out.println("Please enter the order of the task: ");
		int order = in. nextInt();
		list.add(new Task(description, priority, order));
	}
	public static void printUnfinishTask(){
		
	}
	public static void getUnfinishTaskByPriority(){
		
	}
	public static void getAllTasks(){
		String complete = "";
		String cancle = "";
		System.out.printf("\n%-10s %10s %10s %10s %10s %10s %20s\n", 
				"ID", "Task", "Proiority", "Order", "Status", "Date", "Reason");
		for(Task item: list)
		{
			if (item.getIsComplete()){
				complete = "complete";
			}
			else if(item.getIsCancelled()){
				cancle = "cancle";
			}


			//System.out.println(""+ item.getId() + item.getDescription() + item.getPriority() + item.getOrder()+ complete + cancle + item.getExtraInfo());
			System.out.printf("%-5d %15s %10c %10s %10s %10s %10s\n", item.getId(), item.getDescription(), item.getPriority(), item.getOrder(), complete, cancle, item.getExtraInfo());
		}
			
	}
	public static void exitProgram(){
		try {
			System.out.println("Goodbye");
			PrintWriter printWriter = new PrintWriter ("src/Task_List.txt");/////////////
			for(Task item: list)
			{
				printWriter.println(item.toString());
			}
			printWriter.close();////////////////
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
