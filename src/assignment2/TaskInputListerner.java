package assignment2;

public interface TaskInputListerner implements KeyListener, MouseListener, ActionListener, ItemListener  {
	
	public void mousePressed(MouseEvent e) {
		textLabel.setVisible(false);
		text.setVisible(true);				
	}

}
