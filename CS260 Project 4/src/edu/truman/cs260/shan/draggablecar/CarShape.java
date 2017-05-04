package edu.truman.cs260.shan.draggablecar;

import java.awt.*;
import java.awt.geom.*;

/**
   A car shape that can be dragged.
*/
public class CarShape implements DraggableShape
{
	private int currentX;
	private int currentY;
	private int width;
	
	/**
      Constructs a car shape.
      @param x the left of the initial bounding rectangle
      @param y the top of the initial bounding rectangle
      @param width the width of the bounding rectangle
	 */
	public CarShape(int x, int y, int width)
	{
		currentX = x;
		currentY = y;
		this.width = width;
	}

	/** Draw the car shape in the graphics context.
	 * @param g2 the graphics context.
	 */
	public void draw(Graphics2D g2)
	{
		Rectangle2D.Double body
			= new Rectangle2D.Double(currentX, currentY + width / 6, 
									width - 1, width / 6);
		Ellipse2D.Double frontTire
			= new Ellipse2D.Double(currentX + width / 6, currentY + width / 3, 
									width / 6, width / 6);
		Ellipse2D.Double rearTire
         	= new Ellipse2D.Double(currentX + width * 2 / 3, 
         							currentY + width / 3,
         							width / 6, width / 6);

		// The bottom of the front windshield
		Point2D.Double r1
			= new Point2D.Double(currentX + width / 6, currentY + width / 6);
		// The front of the roof
		Point2D.Double r2
			= new Point2D.Double(currentX + width / 3, currentY);
		// The rear of the roof
		Point2D.Double r3
			= new Point2D.Double(currentX + width * 2 / 3, currentY);
		// The bottom of the rear windshield
		Point2D.Double r4
      		= new Point2D.Double(currentX + width * 5 / 6, currentY + width / 6);
		Line2D.Double frontWindshield
      		= new Line2D.Double(r1, r2);
     	Line2D.Double roofTop
         	= new Line2D.Double(r2, r3);
     	Line2D.Double rearWindshield
     		= new Line2D.Double(r3, r4);

     	g2.setColor(Color.GREEN);
     	g2.fill(body);
     	g2.setColor(Color.BLACK);
     	g2.fill(frontTire);
     	g2.fill(rearTire);
     	g2.setColor(Color.RED);
     	g2.draw(frontWindshield);
     	g2.draw(roofTop);
     	g2.draw(rearWindshield);
	}
   
	/** Is the point within the current bounding box of the car shape?
	 * @param p the point to check
	 * @return true if p is in the bounding box and false otherwise
	 */
	public boolean contains (Point p)
	{
		// The height of the car is 1/2 the width
		return currentX <= p.getX() 
			&& p.getX() <= currentX + width 
         	&& currentY <= p.getY() 
         	&& p.getY() <= currentY + width / 2;
	}

	/** Move the upper left corner of the bounding box of the car shape.
	 * 
	 * @param dx the amount to move the box in the x direction.
	 * @param dy the amount to move the box in the y direction.
	 */
	public void move (int dx, int dy)
	{
		currentX += dx;
		currentY += dy;
	}

}