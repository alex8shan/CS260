package edu.truman.cs260.shan.Shape;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
/**
 * The class that implments icon interface. it draw the background as well as different
 * shapes.
 * @author Minghao Shan
 *
 */
public class ShapeContainer implements Icon {
    private int size;
    private int shapeSize;
    private String shape;
    private ArrayList<MovableShape> list = new ArrayList<MovableShape>();
    /**
     * Constructor of ShapeContainer. It initialize the size of the background and the 
     * size of shapes.
     * @param size
     * @param shapeSize
     */
    public ShapeContainer(int size, int shapeSize){
    	this.size = size;
    	this.shapeSize = shapeSize;
    }
    /**
     * Returns the height of the icon.
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
     * Paint the shapes.
     * @param c	The parent component of the icon.
	 * @param g	The graphics context.
	 * @param x	The horizontal coordinate from the left-up corner of the icon.
	 * @param y	The vertical coordinate from the left-up corner of the icon.
     */
    public void paintIcon(Component c, Graphics g, int x, int y){
        Graphics2D g2 = (Graphics2D) g;
        for(MovableShape i : list){
        	i.draw(g2);
        }
    }
    /**
     * Move the shapes.
     */
    public void move(){
    	for(MovableShape i: list){
    		i.move();
    	}
    }
    /**
     * Create different shapes based on the passed parameter.
     * @param shape A string indicating which shape the user want to create.
     */
    public void setShape(String shape){
    	this.shape = shape;
    	if(shape.equals("square")){
        	list.add(new SquareShape(size, shapeSize));
    	}
    	if(shape.equals("circle")){
    		list.add(new CircleShape(size, shapeSize));
    	}
    	if(shape.equals("triangle")){
    		list.add(new TriangleShape(size, shapeSize));
    	}
    }
}
