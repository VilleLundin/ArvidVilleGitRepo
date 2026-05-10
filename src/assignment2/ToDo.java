package assignment2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.TaskListener;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

// Main application class that builds the GUI and handles events and tasks
public class ToDo implements TaskListener {
	
	public static void main(String[] args) {
		ToDo application = new ToDo();
		application.execute();
	}

	private JPanel buttonPanel1;
	private JPanel buttonPanel2;
	private JPanel taskPanel;
	private LinkedList<Task> listOfTasks;
	private LinkedList<Task> listOfUncompletedTasks;
	private JLabel taskCompletionStatus;
	private JFrame frame = new JFrame();

	private ToDo() {}
	public void execute () {

		// label showing how many tasks are completed
		taskCompletionStatus = new JLabel (0 + " out of " + 0 + " tasks completed");

		frame.setSize(750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);

		// this is the panel where all tasks go
		taskPanel = new JPanel(new BorderLayout());
		taskPanel.setLayout(new BoxLayout(taskPanel, 1));

		// Panel for the two rows of buttons
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, 1));
		
		// first row of buttons
		buttonPanel1 = new JPanel();
		
		// create buttons for each type of task
		JButton addHomeTaskButton = Buttons.createButton("Add Home Task", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTask(new HomeTask());
			}
		});
		
		JButton addStudyTaskButton = Buttons.createButton("Add Study Task", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTask(new StudyTask());
			}
		});

		JButton addCustomTaskButton = Buttons.createButton("Add Detailed Task", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTask(new CustomTask());
			}
		});
		
		// add the task buttons to panel to form first row of buttons
		buttonPanel1.add(addHomeTaskButton);
		buttonPanel1.add(addStudyTaskButton);
		buttonPanel1.add(addCustomTaskButton);
		buttonPanel1.add(taskCompletionStatus);
		
		// panel for the second row of buttons
		buttonPanel2 = new JPanel();
		
		// create the sorting buttons
		JButton sortAlphabeticalButton = Buttons.createButton("Sort by A-Ö", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comparatorTaskText();
			}
		});
		
		JButton sortTaskTypeButton = Buttons.createButton("Sort by type Detailed-Home-Study", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comparatorTaskType();
			}
		});
		
		JButton sortTaskCompletionButton = Buttons.createButton("Sort by Uncompleted-Completed", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comparatorTaskCompletion();
			}
		});
		
		// add the sorting buttons to panel to form second row of buttons
		buttonPanel2.add(sortAlphabeticalButton);
		buttonPanel2.add(sortTaskTypeButton);
		buttonPanel2.add(sortTaskCompletionButton);

		// add both panels/rows of buttons to panel at top
		topPanel.add(buttonPanel1);
		topPanel.add(buttonPanel2);

		// adds scroll to the application
		JScrollPane scroll = new JScrollPane(taskPanel);
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(topPanel, BorderLayout.NORTH);
		
		scroll.setViewportView(taskPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// lists containing tasks
		listOfTasks = new LinkedList<Task>();
		listOfUncompletedTasks = new LinkedList<Task>();
		
		frame.setVisible(true);
	}

	// methods using comparator to sort tasks
	private void comparatorTaskText() {
		Comparator<Task> comparator = new ComparatorTaskText();
		Collections.sort(listOfTasks, comparator);
		frame.revalidate();
		rebuildTaskPanel();
	}

	private void comparatorTaskType() {
		Comparator<Task> comparator = new ComparatorTaskType();
		Collections.sort(listOfTasks, comparator);
		frame.revalidate();
		rebuildTaskPanel();
	}

	private void comparatorTaskCompletion() {
		Comparator<Task> comparator = new ComparatorTaskCompletion();
		Collections.sort(listOfTasks, comparator);
		frame.revalidate();
		rebuildTaskPanel();
	}

	// when new task is created, add it to lists and update status text and task panel 
	private void newTask(Task task) {
		listOfTasks.addLast(task);
		listOfUncompletedTasks.addLast(task);
		statusUpdate();
		task.setTaskListener(this);
		taskPanel.add(task.getGuiComponent());
		taskPanel.revalidate();
		taskPanel.repaint();
	}

	// method for placing tasks in correct order according to sorting
	private void rebuildTaskPanel() {
		taskPanel.removeAll();

		for (Task t : listOfTasks) {
			taskPanel.add(t.getGuiComponent());
		}

		taskPanel.revalidate();
		taskPanel.repaint();
	}
	
	private void statusUpdate() {
		taskCompletionStatus.setText(listOfTasks.size() - listOfUncompletedTasks.size() + " out of " + listOfTasks.size() + " tasks completed");
	}

	// when task is completed, remove from list of uncompleted and update status text and panel
	@Override
	public void taskCompleted(Task task) {
		listOfUncompletedTasks.remove(task);
		statusUpdate();
		taskPanel.revalidate();
		taskPanel.repaint();
	}

	// when task is uncomplete, add to list of uncomplete and update status text and panel
	@Override
	public void taskUncompleted(Task task) {
		listOfUncompletedTasks.add(task);
		statusUpdate();
		taskPanel.revalidate();
		taskPanel.repaint();
	}

	// when task is removed, remove it from panel and all lists, update status text and panel
	@Override
	public void taskRemoved(Task task) {
		taskPanel.remove(task.getGuiComponent());
		listOfUncompletedTasks.remove(task);
		listOfTasks.remove(task);
		statusUpdate();		
		taskPanel.revalidate();
		taskPanel.repaint();
	}

	@Override
	public void taskChanged(Task t) {}
	@Override
	public void taskCreated(Task t) {}
}