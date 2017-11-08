import javax.swing.*;
public class MyButton extends JButton{
	public MyButton(String buttonName) {
		if(buttonName != null) {
            setText(buttonName);
        }
		setActionCommand(buttonName);
	}
}
