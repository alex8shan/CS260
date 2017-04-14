package edu.truman.cs260.shan.Shape;
import java.awt.*;
import javax.swing.Icon;

public class ShapeContainer implements Icon {
    private int size;
    /**
     * Rturns the height of the icon.
     * @return height of the icon.
     */
    public int getIconHeight(){
        return size;
    }
    /**
     * Returns the width of the icon.
     * @return width of the icon.
     */
    public int getIconWidth(){
        return size;
    }
    /**
     * Paint the icon.
     * @param c	The parent component of the icon.
	 * @param g	The graphics context.
	 * @param x	The horizontal coordinate from the left-up corner of the icon.
	 * @param y	The vertical coordinate from the left-up corner of the icon.
     */
    public void paintIcon(Component c, Graphics g, int x, int y){
        Graphics2D g2 = (Graphics2D) g;
        //set the color of icon
        //draw the shape
    }
}
