package view;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class soccer_AbsViewTemplate extends soccer_AbsView {
	
	@Override
	public void show() {
		showMenu();
		String input = getKeyInputString("¹øÈ£ ");
		if (isValidNumber(input)) {
			execute(NumberUtils.toInt(input));
		}
	}

	protected boolean isValidNumber(String input) {
		if (StringUtils.isBlank(input)) {
			return false;
		}
		if (!StringUtils.isNumeric(input)) {
			return false;
		}
		int number = NumberUtils.toInt(input);
		if (getMinMenuNumber() <= number && getMaxMenuNumber() >= number) {
			return true;
		}
		return false;
	}
	abstract public void showMenu(); 
	abstract public int getMinMenuNumber();
	abstract public int getMaxMenuNumber();
	abstract public void execute(int number);
}








