import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import edu.truman.cs260.shan.shape_game.*;

/**
 * A program that allows users to move a car with the mouse.
 */
public class SimpleGame {
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 700;
	private static int shapeOrder = -1;



	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drag the shape");
		ShapesComponent shapeComp = new ShapesComponent();
		JPanel panel = new JPanel();
		JTextField gameStat = new JTextField(10);
		gameStat.setText("LOL");
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(gameStat);
		frame.add(gameStat);
		frame.setLayout(new FlowLayout());
		frame.add(panel);
		
		ActionListener moveShape = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(DraggableShape i: shapeComp.getList()){
					i.move();
				}
				shapeComp.repaint();
			}
		};
		
		ActionListener setShape = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeOrder = DraggableShape.r.nextInt(3);
				if(shapeOrder == 0){
					shapeComp.getList().add(new SquareShape(shapeComp.MAX_POS_X, shapeComp.MAX_POS_Y));
				}
				else if(shapeOrder == 1){
					shapeComp.getList().add(new CircleShape(shapeComp.MAX_POS_X, shapeComp.MAX_POS_Y));
				}
				else if(shapeOrder == 2){
					shapeComp.getList().add(new TriangleShape(shapeComp.MAX_POS_X, shapeComp.MAX_POS_Y));
				}
			}
		};
		
		Timer animation = new Timer(42, moveShape);
		
		Timer fireShape = new Timer(1000, setShape);
		animation.start();
		fireShape.start();
		
		
		frame.add(shapeComp);
		

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