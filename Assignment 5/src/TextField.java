import java.awt.Font;

import javax.swing.*;
public class TextField extends JTextField{
	public TextField(int a) {
		super(a);
		setFont(new Font("Verdana", Font.PLAIN, 30));
	}
}
