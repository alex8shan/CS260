package edu.truman.cs260.shan.Icon;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
/**
 * This is the class that implements the Icon interface.
 * @author Minghao Shan
 * @version 04/07/2017
 */

public class iconShape implements Icon{
	/**
	 * The string that identifies which shape the user want.
	 */
	private String iconShape = "";
	/**
	 * The color that identifies which color the user want.
	 */
	private Color iconColor;
	/**
	 * The size of the icon.
	 */
	private int size;
	
	/**
	 * This is the constructor that sets the size of the icon.
	 * @param size	The size of the icon.
	 */
	public iconShape(int size){
		this.size = size;
	}
	
	/**
	 * This method determines shape and color the user want and display
	 * and paint them.
	 * @param c	The parent component of the icon.
	 * @param g	The graphics context.
	 * @param x	The horizontal coordinate from the left-up corner of the icon.
	 * @param y	The vertical coordinate from the left-up corner of the icon.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(iconColor);		
		if(iconShape.equals("Circle")){
			Ellipse2D.Double circle = new Ellipse2D.Double(x,y,size,size);
			g2.fill(circle);
		} else if (iconShape.equals("Square")){
			Rectangle2D.Double square = new Rectangle2D.Double(x,y,size,size);
			g2.fill(square);
		}		
	}
/**
 * This method determines what shape the user want the icon to be.
 * @param shape	The shape the user want the icon to be.
 */
	public void setShape(String shape){
		this.iconShape = shape;
	}

/**
 * This method determines what shape the user want the icon to be.
 * @param color The color the user want the icon to display.
 */
	public void setColor(Color color){
		this.iconColor = color;
	}
/**
 * This method returns the height of the icon.
 * @return	size	The height of the icon.
 */
	public int getIconHeight() {
		return size;
	}

/**
 * This method returns the width of the icon.
 * @return size		The width of the icon.
 */
	public int getIconWidth() {
		return size;
	}
}
