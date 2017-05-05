package edu.truman.cs260.shan.shape_game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import edu.truman.cs260.shan.shape_game.DraggableShape;;
/**
 * A ShapeComponent represents a component that shows different shapes.
 * @author Minghao Shan
 *
 */
public class ShapesComponent extends JComponent{
	private DraggableShape shape;
	private ArrayList<DraggableShape> list = new ArrayList<DraggableShape>();
	public static final int MAX_POS_X = 20;
	public static final int MAX_POS_Y = 20;
	private Point mousePoint;
	
	public ShapesComponent(){
		mousePoint = null;
		setPreferredSize(new Dimension(500,500));
		
		
		
		/*
		 * Create a mouseListener, and add it to this component. This looks odd
		 * because we are calling a method defined in the superclass. If you
		 * prefer, you can write this.addMouseListener().
		 */
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {

				mousePoint = event.getPoint();
				if (!shape.contains(mousePoint))
					mousePoint = null;
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {

			// Notice that there is no timer associated with mouse motion. The
			// operating system will call this method many times a second while
			// the mouse is in motion.
			public void mouseDragged(MouseEvent event) {

				if (mousePoint == null) {
					return;
				}
				// Save the last position of the mouse, and then get the current
				// position.
				Point lastMousePoint = mousePoint;
				mousePoint = event.getPoint();

				// Calculate how much the mouse has moved since we last checked.
				double dx = mousePoint.getX() - lastMousePoint.getX();
				double dy = mousePoint.getY() - lastMousePoint.getY();

				/*
				 * A slight complication here. The point class represents
				 * coordinates as doubles by default. We cast them to ints to
				 * make move() happy.
				 */
				shape.move((int) dx, (int) dy);

				/*
				 * Call JComponent.repaint(). JComponent is our super class.
				 * This method will clear the component window, and then call
				 * paintComponent, which we must override so that it properly
				 * draws the component. We do so below.
				 */
				repaint();
			}
		});
	}
	//mouseListener that detect if the point is outside of the frame.
	//mouseMotionListener that moves the shape.


	public ArrayList<DraggableShape> getList() {
		return list;
	}


	/**
	 * Do the work necessary to draw the contents of this window.
	 * 
	 * @param g
	 *            the graphics context
	 */
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		for(DraggableShape i: getList()){
			i.draw(g2);
		}
		g.drawRect(0, 150, 200, 200);
	}
}