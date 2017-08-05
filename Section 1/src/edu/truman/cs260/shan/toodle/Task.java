/**
 * 
 */
package edu.truman.cs260.shan.toodle;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author minghao
 *
 */
public class Task {
	private String description;
	private int id;
	private char priority;
	private int order;
	private boolean isComplete;
	private boolean isCancelled;
	private Date date;
	private String reason = " ";
	char completed;
	char cancelled;
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	private static int nextID = 0;
	
	public Task(String description, char priority, int order){
		this.description = description;
		id = nextID;
		nextID++;
		this.priority = priority;
		this.order = order;
		isComplete = false;
		isCancelled = false;
		reason = " ";
		}
	public Task(String copy) throws ParseException{
		id = nextID;
		nextID++;
		String[] content = copy.split("~");
		if(content[0].charAt(0) == 't'){
			isComplete = true;		
		}
		if(content[1].charAt(0) == 't'){
			isCancelled = true;		
		}
		order = Integer.parseInt(content[2]);
		priority = content[3].charAt(0);
		description = content[4];
		date = dateFormat.parse(content[5]);		
		reason = content[6];		
	}
	public int getId(){
		return id;
	}
	public char getPriority(){
		return priority;
	}
	public String getDescription(){
		return description;
	}
	public boolean getIsComplete(){
		return isComplete;
	}
	public boolean getIsCancelled(){
		return isCancelled;
	}
	public int getOrder(){
		return order;
	}
	public void setComplete(){
		this.date = new Date();
		isComplete = true;
	}
	public String getExtraInfo(){
		if(isComplete == true){
			
			return dateFormat.format(date);
		} else if (isCancelled == true){
			return reason;
		} else{
			return "";
		}
	}
	public void setCancelled(String reason){
		this.reason = reason;
		isCancelled = true;
	}
	public String toString(){
		if(isComplete){
			completed = 't';
		} else {
			completed = 'f';
		}
		if (isCancelled){
			cancelled = 't';
		} else {
			cancelled = 'f';
		}
		return (completed + "~" + cancelled + "~"+ order + "~" + priority + "~" + description + "~"  + dateFormat.format(date) + "~" + reason);
	}
}
