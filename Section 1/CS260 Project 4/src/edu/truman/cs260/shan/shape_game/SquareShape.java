package edu.truman.cs260.shan.shape_game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class SquareShape extends DraggableShape{

	public SquareShape(int max_initial_x_pos, int max_initial_y_pos) {
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
		Rectangle2D square = new Rectangle2D.Double(super.getShapeCurrentX(),super.getShapeCurrentY() , super.getShapeHeight(), super.getShapeWidth());
    	g2.fill(square);
	}

}
