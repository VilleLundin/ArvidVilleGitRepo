package assignment2;

import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.TaskListener;

public class Buttons {
	
//	this method is static because it provides general functionality and does not depend on
// 	instance specific data
	public static JButton createButton(String text, ActionListener listener) {
		JButton button = new JButton(text);
		button.addActionListener(listener);
		
		return button;
	}
}