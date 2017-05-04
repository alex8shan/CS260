 package edu.truman.cs260.shan.draggablecar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A CarComponent represents a component that shows a car.
 */
public class CarComponent extends JComponent {

	// The draggable thing that fills the scene
	private DraggableShape car;

	// The last position of the mouse
	private Point mousePoint;

	// The car's measurements
	public static final int INITIAL_X_POS = 20;
	public static final int INITIAL_Y_POS = 20;
	public static final int CAR_WIDTH = 250;
	
	public static final int COMPONENT_WIDTH = 500;
	public static final int COMPONENT_HEIGHT = 500;

	/**
	 * Create a new car shape object and then attach listeners for the mouse
	 * actions we care about.
	 */
	public CarComponent() {

		// create the car object
		car = new CarShape(INITIAL_X_POS, INITIAL_Y_POS, CAR_WIDTH);
		mousePoint = null;
		
		// Set the size of the component.
		setSize (COMPONENT_WIDTH, COMPONENT_HEIGHT);

		/*
		 * Create a mouseListener, and add it to this component. This looks odd
		 * because we are calling a method defined in the superclass. If you
		 * prefer, you can write this.addMouseListener().
		 */
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {

				mousePoint = event.getPoint();
				if (!car.contains(mousePoint))
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
				car.move((int) dx, (int) dy);

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

	/**
	 * Do the work necessary to draw the contents of this window.
	 * 
	 * @param g
	 *            the graphics context
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		car.draw(g2);
	}
}