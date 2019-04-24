import java.awt.event.ActionEvent;
import java.util.regex.*;
import java.awt.event.ActionListener;
/**
 * This class specifies what will happen when the calculator buttons are clicked.
 * @author Minghao Shan
 * @version 11/10/2017
 */
public class CommonActionListener implements ActionListener{
	static String displayText = "";
	/**
	 * Haddler method
	 */
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
			case "0":
				displayText = displayText + "0";
				Calculator.getOutput().setText(displayText);
				break;
			case "1":
				displayText = displayText + "1";
				Calculator.getOutput().setText(displayText);
				break;
			case "2":
				displayText = displayText + "2";
				Calculator.getOutput().setText(displayText);
				break;
			case "3":
				displayText = displayText + "3";
				Calculator.getOutput().setText(displayText);
				break;
			case "4":
				displayText = displayText + "4";
				Calculator.getOutput().setText(displayText);
				break;
			case "5":
				displayText = displayText + "5";
				Calculator.getOutput().setText(displayText);
				break;
			case "6":
				displayText = displayText + "6";
				Calculator.getOutput().setText(displayText);
				break;
			case "7":
				displayText = displayText + "7";
				Calculator.getOutput().setText(displayText);
				break;
			case "8":
				displayText = displayText + "8";
				Calculator.getOutput().setText(displayText);
				break;
			case "9":
				displayText = displayText + "9";
				Calculator.getOutput().setText(displayText);
				break;
			case "+":
				displayText = displayText + "+";
				Calculator.getOutput().setText(displayText);
				break;
			case "-":
				displayText = displayText + "-";
				Calculator.getOutput().setText(displayText);
				break;
			case "*":
				displayText = displayText + "*";
				Calculator.getOutput().setText(displayText);
				break;
			case "/":
				displayText = displayText + "/";
				Calculator.getOutput().setText(displayText);
				break;
			case "AC":
				displayText = "";
				Calculator.getOutput().setText("Cleared");
				break;
            case "Sin":
                displayText = displayText + "Sin";
                Calculator.getOutput().setText(displayText);
                break;
            case "Cos":
                displayText = displayText + "Cos";
                Calculator.getOutput().setText(displayText);
                break;
            case "Tan":
                displayText = displayText + "Tan";
                Calculator.getOutput().setText(displayText);
                break;
            case "Sec":
                displayText = displayText + "Sec";
                Calculator.getOutput().setText(displayText);
                break;
            case "Csc":
                displayText = displayText + "Csc";
                Calculator.getOutput().setText(displayText);
                break;
            case "Cot":
                displayText = displayText + "Cot";
                Calculator.getOutput().setText(displayText);
                break;
            case "log()":
                displayText = displayText + "log ";
                Calculator.getOutput().setText(displayText);
                break;
            case "^2":
                displayText = displayText + "^2";
                Calculator.getOutput().setText(displayText);
                break;
            case "=":
				if(displayText.indexOf('+')>=0 && displayText.indexOf('+') < displayText.length()-1) {
					String [] numbers = displayText.split("\\+");
					Calculator.getOutput().setText(Integer.toString(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])));
					displayText = "";
				} else if(displayText.indexOf('-')>=0 && displayText.indexOf('-') < displayText.length()-1) {
					String [] numbers = displayText.split("-");
					Calculator.getOutput().setText(Integer.toString(Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1])));
					displayText = "";
				} else if (displayText.indexOf('*')>=0 && displayText.indexOf('*') < displayText.length()-1) {
					String [] numbers = displayText.split("\\*");
					Calculator.getOutput().setText(Integer.toString(Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1])));
					displayText = "";
				} else if (displayText.indexOf('/')>=0 && displayText.indexOf('/') < displayText.length()-1) {
					String[] numbers = displayText.split("/");
					Calculator.getOutput().setText(Integer.toString(Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1])));
					displayText = "";
				} else if (displayText.indexOf("Sin")>=0 && displayText.indexOf("Sin") < displayText.length()-1) {
                    Calculator.getOutput().setText(Double.toString(Math.sin(Integer.parseInt(displayText.substring(3, displayText.length())))));
					displayText = "";
				} else if (displayText.indexOf("Cos")>=0 && displayText.indexOf("Cos") < displayText.length()-1) {
					Calculator.getOutput().setText(Double.toString(Math.cos(Integer.parseInt(displayText.substring(3, displayText.length())))));
					displayText = "";
				} else if (displayText.indexOf("Tan")>=0 && displayText.indexOf("Tan") < displayText.length()-1) {
                    Calculator.getOutput().setText(Double.toString(Math.tan(Integer.parseInt(displayText.substring(3, displayText.length())))));
					displayText = "";
				} else if (displayText.indexOf("Sec")>=0 && displayText.indexOf("Sec") < displayText.length()-1) {
                    Calculator.getOutput().setText(Double.toString(1.0 / Math.cos(Integer.parseInt(displayText.substring(3, displayText.length())))));
					displayText = "";
				} else if (displayText.indexOf("Csc")>=0 && displayText.indexOf("Csc") < displayText.length()-1) {
                    Calculator.getOutput().setText(Double.toString(1.0 / Math.sin(Integer.parseInt(displayText.substring(3, displayText.length())))));
					displayText = "";
				} else if (displayText.indexOf("Cot")>=0 && displayText.indexOf("Cot") < displayText.length()-1) {
                    Calculator.getOutput().setText(Double.toString(1.0 / Math.tan(Integer.parseInt(displayText.substring(3, displayText.length())))));
					displayText = "";
				} else if (displayText.indexOf("log ")>=0 && displayText.indexOf("log ") < displayText.length()-1) {
                    Calculator.getOutput().setText(Double.toString(Math.log10(Integer.parseInt(displayText.substring(4, displayText.length())))));
                    displayText = "";
                } else if (displayText.indexOf("^2")>=0 && displayText.indexOf("^2") < displayText.length()-1) {
                    Calculator.getOutput().setText(Integer.toString(Integer.parseInt(displayText.substring(0, displayText.length()-2)) * Integer.parseInt(displayText.substring(0, displayText.length()-2))));
                    displayText = "";
                } else {
					Calculator.getOutput().setText("Illegal input!");
					displayText = "";
				}
				break;
		}
	}
}
