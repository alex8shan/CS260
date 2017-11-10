import java.awt.*;
import javax.swing.*;
/**
 * This class is the Calculator class that implements the GUI part
 * @author Minghao Shan
 * @version 11/10/2017
 */
public class Calculator extends JFrame //implements ActionListener 
{
	private JButton buttons[] = new JButton[16];
	private String captions[] = {"1","2","3","+",
									"4","5","6","-",
									"7","8","9","/",
									"0","=","AC","*"};
	private JPanel buttonPanel = (new JPanel(new GridLayout(4, 4)));
	static JTextField output = new TextField(15);
	
	Container frame;
	/**
	 * Constructor
	 */
	public Calculator()
	{
		frame = getContentPane();
		for (int count=0;count<16;count++)
		{
			buttons[count] = new MyButton(captions[count]);
			buttonPanel.add(buttons[count]);
			buttons[count].addActionListener(new CommonActionListener());
		}
		frame.setLayout(new BorderLayout());
		frame.add(output,BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	/**
	 * Accessor to get the JTextField Object
	 * @return	The object 
	 */
	public static JTextField getOutput() {
		return output;
	}
    public static void main(String[] arguments) 
    {
        Calculator c = new Calculator();
    }
}