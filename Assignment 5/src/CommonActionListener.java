import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonActionListener implements ActionListener{
	static String displayText = "";
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
			case "0":
				displayText = displayText + "0";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "1":
				displayText = displayText + "1";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "2":
				displayText = displayText + "2";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "3":
				displayText = displayText + "3";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "4":
				displayText = displayText + "4";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "5":
				displayText = displayText + "5";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "6":
				displayText = displayText + "6";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "7":
				displayText = displayText + "7";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "8":
				displayText = displayText + "8";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "9":
				displayText = displayText + "9";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "+":
				displayText = displayText + "+";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "-":
				displayText = displayText + "-";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "*":
				displayText = displayText + "*";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "\\":
				displayText = displayText + "\\";
				CalculatorDriver.textField.setText(displayText);
				break;
			case "AC":
				displayText = "";
				CalculatorDriver.textField.setText("Cleared");
				break;
			case "=":
				
				CalculatorDriver.textField.setText("Equals");
				break;
		}
	}
}
