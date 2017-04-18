package edu.truman.cs260.shan.Shape;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

class SquareShape implements MovableShape{
	private int xCoor = 0;
	private int dx;
	private int dy;
	private int yCoor = 0;
	private int size;
	/**
	 * 
	 * @param size
	 */
	public SquareShape(int size){
		//assign random dx & dy
		this.size = size;
		dx = new Random().nextInt(5);
		dy = new Random().nextInt(5);
	}
	/**
	 * 
	 */
    public void move(){
    	//move the coordinate
		xCoor = xCoor + dx;
		yCoor = yCoor + dy;
		
		//inverse the dx move
		if((0 > xCoor) && (xCoor > size)){
			dx = -dx;
		}
		//inverse the dy move
		if((0 > yCoor) && (yCoor > size)){
			dy = -dy;
		}
		System.out.println(xCoor + "   " + yCoor);
    }
    /**
     * 
     */
    public void draw(Graphics2D g2){
    	Rectangle2D square = new Rectangle2D.Double(xCoor, yCoor, 50, 50);
    	g2.fill(square);
    }
}