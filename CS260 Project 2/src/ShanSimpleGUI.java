import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import edu.truman.cs260.shan.Icon.iconShape;

/**
 * This is the main class that have four buttons. When user
 * clicks the shape and color buttons, the corresponding shape
 * and colors will be displayed.
 * @author  Minghao Shan
 * @version 04/07/2017
 *
 */
public class ShanSimpleGUI {

	/**
	 * This is the main method.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();//create a frame
		FlowLayout layout = new FlowLayout();//create a layout
		
		//create 4 buttons
		JButton circle = new JButton("Circle");
		JButton square = new JButton("Square");
		JButton blue = new JButton("Blue");
		JButton red = new JButton("Red");
		final iconShape icon = new iconShape(100);
		final JLabel myLabel = new JLabel(icon);
		
		//add buttons and labels to frame
		frame.add(circle);
		frame.add(square);
		frame.add(blue);
		frame.add(red);
		frame.add(myLabel);
		//add action listener to circle button
		circle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setShape("Circle");
				myLabel.repaint();
			}
		});
		//add action listener to square button
		square.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setShape("Square");
				myLabel.repaint();
			}
		});
		//add action listener to blue button
		blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setColor(Color.blue);
				myLabel.repaint();
			}
		});
		//add action listener to red button
		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setColor(Color.red);
				myLabel.repaint();
			}
		});
		
		//set the layout to the frame
		frame.setLayout(layout);
		
		//set the frame to close after close the windows
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		//set size of the frame
		frame.setSize(500, 200);
		//set visible
		frame.setVisible(true);
	}

}
