package assignment2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.TaskListener;

public class CustomTask extends JPanel implements Task {
	/**
	 * The editable text field. 
	 */
	private JTextField text;
	
	/**
	 * The non editable text label.
	 */
	private JLabel textLabel;
	
	/**
	 * Check box holding the completion status. 
	 */
	JCheckBox completed = new JCheckBox();
	
	/**
	 * The task listener used for reporting changes to the main application. 
	 */
	private TaskListener listener;
	
	/**
	 * This is the constructor for the task, initiating the GUI component for the task. Several listeners are used to react to various events in the GUI.  
	 */
	public CustomTask() {
		super(new BorderLayout());
		this.text = new JTextField("New task",20);
		JTextArea textDescription = new JTextArea("Description", 5,10);
		this.textLabel = new JLabel();
		this.textLabel.setVisible(false);
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center,1));
		center.add(text);
		center.add(textLabel);
		center.add(textDescription);
		add(center);
        textDescription.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(center);
		this.add(scroll, BorderLayout.CENTER);
//		.add(, BorderLayout.NORTH);

		scroll.setViewportView(center);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		TaskInputListener inputListener = new TaskInputListener(this, text, textLabel);
		this.text.addKeyListener(inputListener);
		this.textLabel.addMouseListener(inputListener);
		
		JButton remove = new JButton("Remove");
		add(remove,BorderLayout.EAST);
		remove.addActionListener(inputListener);
		
		add(completed,BorderLayout.WEST);
		completed.addItemListener(inputListener);
		
		setMaximumSize(new Dimension(1000,100));
		setBorder(new TitledBorder(getTaskType()));
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text.getText();
	}

	@Override
	public String getTaskType() {
		// TODO Auto-generated method stub
		return "Custom";
	}

	@Override
	public void setTaskListener(TaskListener t) {
		// TODO Auto-generated method stub
		listener = t;
		
	}

	@Override
	public TaskListener getTaskListener() {
		// TODO Auto-generated method stub
		return listener;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return completed.isSelected();
	}

	@Override
	public Component getGuiComponent() {
		// TODO Auto-generated method stub
		return this;
	}

}
