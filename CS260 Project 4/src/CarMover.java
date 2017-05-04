import javax.swing.*;

import edu.truman.cs260.shan.draggablecar.*;

/**
 * A program that allows users to move a car with the mouse.
 */
public class CarMover {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Draggable Car");

		frame.add(new CarComponent());

		/* Normally, a frame is just large enough to hold its components. The
		 * size is determined by which Layout is used and what is in the frame
		 * when it is packed. If don't want Swing to determine the frame size
		 * for us, we can specify that with the setSize() method. If we do this,
		 * we don't (and in fact should not) apply a Layout or pack the
		 * frame.
		 * 
		 * Be careful here - the frame must be large enough to hold its
		 * contents, so you may have to do some arithmetic.
		 */
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		// Important: don't call setLayout() and don't call pack(). We are
		// handling the frame size ourselves.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}