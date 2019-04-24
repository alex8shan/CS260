import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
public class MyButton extends JButton{
	public MyButton(String buttonName) {
		if(buttonName != null) {
            setText(buttonName);
            setPreferredSize(new Dimension(70, 70));
            setFont(new Font("Arial", Font.PLAIN, 20));
        }
		setActionCommand(buttonName);
	}
}
