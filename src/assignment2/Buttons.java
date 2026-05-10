package assignment2;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Buttons {
	
//	this method is static because it provides general functionality and does not depend on
// 	instance specific data
	public static JButton createButton(String text, ActionListener listener) {
		JButton button = new JButton(text);
		button.addActionListener(listener);
		return button;
	}
}