import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.truman.cs260.shan.Shape.ShapeContainer;
import edu.truman.cs260.shan.Shape.MovableShape;

public class BouncyShapes {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();//create a frame
		FlowLayout layout = new FlowLayout();//create a layout
		
		//create buttons
		JButton circle = new JButton("Circle");
		JButton square = new JButton("Square");
		JButton triangle = new JButton("Triangle");
		final ShapeContainer icon = new ShapeContainer(500);//create the background
		final JLabel myLabel = new JLabel(icon);//create the label
		
		//add buttons and labels to frame
		frame.add(circle);
		frame.add(square);
		frame.add(triangle);
		frame.add(myLabel);
		

		ActionListener moveShape = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				icon.move();
				myLabel.repaint();
			}
		};
		Timer t = new Timer(42, moveShape);
		
		//add action listener to square button
		square.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setShape("square");
			}
		});

		//add action listener to circle button
		circle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setShape("circle");
			}
		});
		//add action listener to triangle button
		triangle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setShape("triangle"); 
			}
		});
		
		t.start();
		
		//set the layout to the frame
		frame.setLayout(layout);
		
		//set the frame to close after close the windows
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		//set size of the frame
		frame.setSize(800, 600);
		//set visible
		frame.setVisible(true);
	}

}
