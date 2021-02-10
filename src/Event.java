import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Event implements ActionListener {
	
	String num1 = "";
	String num2 = "";
	String operator = "";
	double num1Double = 0;
	double num2Double = 0;
	CalcWindowBuilder gui;
	boolean operatorSet = false;
	double answer = 0;
	String displayText = "";
	boolean equalPressed;
	
	public Event(CalcWindowBuilder calcGui) {
		gui = calcGui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if (command == "+" || command == "-" || command == "x" || command == "/") {
			setOperator(command);
		}
		else if (command == "=") {
			calculate();
			equalPressed = true;
		}
		else if (command == "clr") {
			clear();
		}
		else {
			addNum(command);
		}

	}
	
	public void setOperator(String op) {
		operator = op;
		operatorSet = true;
		gui.textField.setText(operator);
	}
	
	public void addNum(String num) {
		if (operatorSet == false) {
			if (equalPressed == false) {
				num1 = num1 + num;
			}
			else {
				num1 = num;
				equalPressed = false;
			}
			gui.textField.setText(num1);
		}
		else {
			num2 = num2 + num;
			gui.textField.setText(num2);
		}
	}
	
	public void calculate() {
		num1Double = Double.parseDouble(num1);
		num2Double = Double.parseDouble(num2);
		
		switch (operator) {
			case "+":
				answer = num1Double + num2Double;
				break;
			case "-":
				answer = num1Double - num2Double;
				break;
			case "/":
				answer = num1Double / num2Double;
				break;
			case "x":
				answer = num1Double * num2Double;
				break;
		}
		gui.textField.setText(String.valueOf(answer));
		num1 = String.valueOf(answer);
		num2 = "";
		operatorSet = false;
	}
	
	public void clear() {
		num1 = "";
		num2 = "";
		operatorSet = false;
		equalPressed = false;
		gui.textField.setText("clr");
	}
}
