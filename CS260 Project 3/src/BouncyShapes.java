import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.truman.cs260.shan.Shape.ShapeContainer;
import edu.truman.cs260.shan.Shape.MovableShape;

public class BouncyShapes {
	public static void main(String[] args) {
		//create shape variable
		final int DELAY = 24;

		// create frame
		// create components:icons, Jlabel
		// add action listener for icons
		// set layout to frame
		//finish frame and everything
		
		JFrame frame = new JFrame();//create a frame
		FlowLayout layout = new FlowLayout();//create a layout
		
		//create buttons
		JButton circle = new JButton("Circle");
		JButton square = new JButton("Square");
		JButton triangle = new JButton("Triangle");
		final ShapeContainer icon = new ShapeContainer(500);
		final JLabel myLabel = new JLabel(icon);
		
		//add buttons and labels to frame
		frame.add(circle);
		frame.add(square);
		frame.add(triangle);
		frame.add(myLabel);
//		//add action listener to circle button
//		circle.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent event){
//				icon.setShape("Circle");
//				myLabel.repaint();
//			}
//		});
		//add action listener to square button
		ActionListener moveSquare = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				myLabel.repaint();
			}
		};
		Timer tSquare = new Timer(100, moveSquare);
		square.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				tSquare.start();
			}
		});

		
		
//		//add action listener to blue button
//		blue.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent event){
//				icon.setColor(Color.blue);
//				myLabel.repaint();
//			}
//		});

		
		//set the layout to the frame
		frame.setLayout(layout);
		
		//set the frame to close after close the windows
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		//set size of the frame
		frame.setSize(800, 500);
		//set visible
		frame.setVisible(true);

		

	}

}
