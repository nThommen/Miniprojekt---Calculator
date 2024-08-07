import java.awt.event.ActionEvent;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void clear() {
		model.calcParts.clear();
		model.current.delete(0, model.current.length());
	}

	public void clearEntry() {
		model.current.delete(0, model.current.length());
	}

	public void erase() {
		model.current.deleteCharAt(model.current.length() - 1);
	}

	public void calculate() {
		model.updateCalcParts();

		for (int i = 1; i < model.calcParts.size() - 1; i++) {
			String part = model.calcParts.get(i);

			if (part.equals("*") || part.equals("/")) {
				double leftOperand = Double.parseDouble(model.calcParts.get(i - 1));
				double rightOperand = Double.parseDouble(model.calcParts.get(i + 1));
				double res;
				switch (part) {
					case "*":
						res = leftOperand * rightOperand;
						break;

					default:
						res = leftOperand / rightOperand;
						break;
				}
				model.calcParts.set(i - 1, Double.toString(res));
				model.calcParts.remove(i);
				model.calcParts.remove(i);
				i--;

			}

		}

		for (int i = 0; i < model.calcParts.size(); i++) {
			String part = model.calcParts.get(i);

			if (part.equals("-") || part.equals("+")) {
				double leftOperand = Double.parseDouble(model.calcParts.get(i - 1));
				double rightOperand = Double.parseDouble(model.calcParts.get(i + 1));
				double res;
				switch (part) {
					case "+":
						res = leftOperand + rightOperand;
						System.out.println("plus");
						break;

					default:
						res = leftOperand - rightOperand;
						System.out.println("minus");
						break;
				}
				model.calcParts.set(i - 1, Double.toString(res));
				model.calcParts.remove(i);
				model.calcParts.remove(i);
				i--;
			}

		}

		model.current.replace(0, model.current.length(), model.calcParts.toString());
		model.calculated = true;
		update();
	}

	public void addSymbol(String command) {
		model.current.append(command);
	}

	public void handleButtonEvent(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
			case "ce":
				clearEntry();
				update();
				break;
			case "c":
				clear();
				update();
				break;
			case "erase":
				erase();
				update();
				break;
			case "=":
				calculate();
				update();
				break;
			default:
				if (model.calculated) {
					clear();
					model.calculated = false;
				}
				addSymbol(command);
				update();
				break;
		}
	}

	public void update() {
		view.calcField.setText(model.current.toString());
	}

}