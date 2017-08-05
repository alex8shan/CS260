import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * 
 * @author mingh
 *
 */
public class ObserverPattern {

	public static void main(String[] args) {
		final int MIN = 0;
		final int MAX = 100;
		// Create the frame and layout
		JFrame frame = new JFrame();
		FlowLayout layout = new FlowLayout();
		final JSlider slider = new JSlider(MIN, MAX);
		final JTextField textField = new JTextField("0");
		
		slider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				Integer sliderPos = slider.getValue();
				textField.setText(sliderPos.toString());
			}
		});
		frame.add(textField);
		frame.add(slider);
		frame.setLayout(layout);
		
		//set the frame to close after close the windows
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		//set size of the frame
		frame.setSize(300,100);
		//set visible
		frame.setVisible(true);
	}

}
