import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * This is the driver class for claculator
 * @author Minghao Shan
 *
 */
public class CalculatorDriver {
	static JTextField textField;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel textPanel = new JPanel();
		textField = new JTextField("Hello!",30);
		textPanel.add(textField);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,4));
		
		JButton b0 = new MyButton("0");
		JButton b1 = new MyButton("1");
		JButton b2 = new MyButton("2");
		JButton b3 = new MyButton("3");
		JButton b4 = new MyButton("4");
		JButton b5 = new MyButton("5");
		JButton b6 = new MyButton("6");
		JButton b7 = new MyButton("7");
		JButton b8 = new MyButton("8");
		JButton b9 = new MyButton("9");
		JButton bPlus = new MyButton("+");
		JButton bMinus = new MyButton("_");
		JButton bTimes = new MyButton("*");
		JButton bDivides = new MyButton("\\");
		JButton bReset = new MyButton("AC");
		JButton bEquals = new MyButton("=");
		
		b0.addActionListener(new CommonActionListener());
		b1.addActionListener(new CommonActionListener());
		b2.addActionListener(new CommonActionListener());
		b3.addActionListener(new CommonActionListener());
		b4.addActionListener(new CommonActionListener());
		b5.addActionListener(new CommonActionListener());
		b6.addActionListener(new CommonActionListener());
		b7.addActionListener(new CommonActionListener());
		b8.addActionListener(new CommonActionListener());
		b9.addActionListener(new CommonActionListener());
		bPlus.addActionListener(new CommonActionListener());
		bMinus.addActionListener(new CommonActionListener());
		bTimes.addActionListener(new CommonActionListener());
		bDivides.addActionListener(new CommonActionListener());
		bReset.addActionListener(new CommonActionListener());
		bEquals.addActionListener(new CommonActionListener());
		
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(bPlus);
		buttonPanel.add(b4);
		buttonPanel.add(b5);
		buttonPanel.add(b6);
		buttonPanel.add(bMinus);
		buttonPanel.add(b7);
		buttonPanel.add(b8);
		buttonPanel.add(b9);
		buttonPanel.add(bTimes);
		buttonPanel.add(bDivides);
		buttonPanel.add(b0);
		buttonPanel.add(bReset);
		buttonPanel.add(bEquals);
		
		frame.setLayout(new BorderLayout(10,10));
		frame.add(textPanel,BorderLayout.PAGE_START);
		frame.add(buttonPanel,BorderLayout.CENTER);

		frame.setTitle("Calculator");
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
