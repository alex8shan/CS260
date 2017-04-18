package edu.truman.cs260.shan.Shape;
import java.awt.Graphics2D;

class CircleShape implements MovableShape{
	private int xCoor = 0;
	private int dx;
	private int dy;
	private int yCoor = 0;
	private int iconSize;
	
	public CircleShape(int iconSize){
		//assign random dx & dy
		this.iconSize = iconSize;
	}
    public void move(){
    	//move the coordinate
		xCoor = xCoor + dx;
		yCoor = yCoor + dy;
		
		//inverse the dx move
		if((0 > xCoor) && (xCoor > iconSize)){
			dx = -dx;
		}
		//inverse the dy move
		if((0 > yCoor) && (yCoor > iconSize)){
			dy = -dy;
		}
    }
    public void draw(Graphics2D g2){
    	
    }
}