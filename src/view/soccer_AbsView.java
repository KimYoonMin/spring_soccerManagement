package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class soccer_AbsView {
	protected String getKeyInputString(String str) {
		String input = JOptionPane.showInputDialog(str+"ют╥б : ");
		return input;
	}
	protected String getEnter() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
	protected void msg(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	abstract public void show();
}











