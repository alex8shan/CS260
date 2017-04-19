package edu.truman.cs260.shan.Shape;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class ShapeContainer implements Icon {
    private int size;
    private int shapeSize;
    private String shape;
    private ArrayList<MovableShape> list = new ArrayList<MovableShape>();
    /**
     * Returns the height of the icon.
     * @return height of the icon.
     */
    public ShapeContainer(int size, int shapeSize){
    	this.size = size;
    	this.shapeSize = shapeSize;
    }
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
        for(MovableShape i : list){
        	i.draw(g2);
        }
    }
    public void move(){
    	for(MovableShape i: list){
    		i.move();
    	}
    }
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
