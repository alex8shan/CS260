package edu.truman.cs260.shan.shape_game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class TriangleShape extends DraggableShape{

	public TriangleShape(int max_initial_x_pos, int max_initial_y_pos) {
		super(max_initial_x_pos, max_initial_y_pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Graphics2D g2) {
		Point2D point1 = new Point2D.Double(super.getShapeWidth()/2 + super.getShapeCurrentX(),0 + super.getShapeCurrentY());
    	Point2D point2 = new Point2D.Double(0 + super.getShapeCurrentX(),super.getShapeWidth() + super.getShapeCurrentY());
    	Point2D point3 = new Point2D.Double(super.getShapeWidth() + super.getShapeCurrentX(),super.getShapeWidth() + super.getShapeCurrentY());
    	Line2D line1 = new Line2D.Double(point1, point2);
    	Line2D line2 = new Line2D.Double(point1, point3);
    	Line2D line3 = new Line2D.Double(point2, point3);
    	g2.draw(line1);
    	g2.draw(line2);
    	g2.draw(line3);
	}

}
