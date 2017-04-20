package edu.truman.cs260.shan.Shape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;
/**
 * THis class creates triangle shapes.
 * @author Minghao Shan
 *
 */
class TriangleShape implements MovableShape{
	private int size;
	private int shapeSize;
	private int xCoor = 0;
	private int yCoor = 0;
	private int dx;
	private int dy;
	private Random r = new Random();
	private Color c = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
	
	/**
	 * Constructor of TriangleShape. It initialize the shape size and the background
	 * size, as well as randomly generate the movement speed of the shape.
	 * @param size	The size of the background
	 * @param shapeSize	The size of the shape
	 */
	public TriangleShape(int size, int shapeSize){
		this.size = size;
		this.shapeSize = shapeSize;
		//assign random dx & dy
		dx = r.nextInt(5) + 1;
		dy = r.nextInt(5) + 1;
	}
	/**
	 * Moves the triangle shape and reverse the movement of triangle if it touches the 
	 * boarder of the background.
	 */
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
    }/**
	 * Draw the triangle shape.
	 * @param g2 the 2D graphics context.
	 */
    public void draw(Graphics2D g2){
    	Point2D point1 = new Point2D.Double(shapeSize/2 + xCoor,0 + yCoor);
    	Point2D point2 = new Point2D.Double(0 + xCoor,shapeSize + yCoor);
    	Point2D point3 = new Point2D.Double(shapeSize + xCoor,shapeSize + yCoor);
    	Line2D line1 = new Line2D.Double(point1, point2);
    	Line2D line2 = new Line2D.Double(point1, point3);
    	Line2D line3 = new Line2D.Double(point2, point3);
    	g2.setColor(c);
    	g2.draw(line1);
    	g2.draw(line2);
    	g2.draw(line3);
    }
}