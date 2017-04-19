package edu.truman.cs260.shan.Shape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.util.Random;

class CircleShape implements MovableShape{
	private int xCoor = 0;
	private int yCoor = 0;
	private int dx;
	private int dy;
	private int size;
	private int shapeSize;
	private Random r = new Random();
	private Color c = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
	
	public CircleShape(int size, int shapeSize){
		this.size = size;
		this.shapeSize = shapeSize;
		//assign random dx & dy
		dx = r.nextInt(5) + 1;
		dy = r.nextInt(5) + 1;
	}
    public void move(){
    	//move the coordinate
		xCoor = xCoor + dx;
		yCoor = yCoor + dy;
		
		//inverse the dx move
		if((0 > xCoor) || (xCoor + shapeSize > size)){
			dx = -dx;
		}
		//inverse the dy move
		if((0 > yCoor) || (yCoor + shapeSize > size)){
			dy = -dy;
		}
    }
    public void draw(Graphics2D g2){
    	Ellipse2D square = new Ellipse2D.Double(xCoor, yCoor, shapeSize, shapeSize);
    	g2.setColor(c);
    	g2.fill(square);
    }
}