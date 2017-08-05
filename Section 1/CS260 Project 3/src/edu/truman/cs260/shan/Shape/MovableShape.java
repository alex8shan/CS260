package edu.truman.cs260.shan.Shape;
import java.awt.*;
/**
 * The interface that makes each shape move and draw itself.
 * @author Minghao Shan
 *
 */
public interface MovableShape {
    public void move();
    public void draw(Graphics2D g2);
}
