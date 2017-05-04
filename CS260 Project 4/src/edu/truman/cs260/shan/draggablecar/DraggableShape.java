package edu.truman.cs260.shan.draggablecar;

import java.awt.Graphics2D;
import java.awt.Point;

public interface DraggableShape {
	
	/** Does this object contain point p
	 * @param p the point to test
	 * @return true if this object contains p, and false otherwise
	 */
	boolean contains (Point p);
	
	/** Move this object
	 * @param dx the amount to move in the x direction
	 * @param dy the amount to move in the y direction
	 */
	void move (int dx, int dy);
	
	/** Draw the object
	 * @param g2 the graphics context
	 */
	void draw (Graphics2D g2);
}