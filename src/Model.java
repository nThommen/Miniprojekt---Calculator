import java.util.ArrayList;
import java.util.Arrays;

public class Model {
	
	StringBuilder current = new StringBuilder();
	String calc = "";
	ArrayList<String> calcParts = new ArrayList<>();
	boolean calculated = false;

	public void updateCalcParts() {
		calc = current.toString();
		calcParts = new ArrayList<>(Arrays.asList(calc.split("(?<=\\+|\\-|\\*|\\/)|(?=\\+|\\-|\\*|\\/)")));
	}

	public boolean isInteger(String part) {
		try {
			Integer.parseInt(part);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
