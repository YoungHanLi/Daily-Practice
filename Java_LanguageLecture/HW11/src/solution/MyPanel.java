package solution;
import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel{
	class MyAction extends AbstractAction{
		public MyAction(String buttonName) {
			putValue(Action.NAME, buttonName);
			putValue("Info", buttonName);
			putValue(Action.SHORT_DESCRIPTION, "Help for " + buttonName);
		}
		
		public void actionPerformed(ActionEvent event) {
			if(((String)this.getValue(Action.NAME)).equals("Quit"))
				System.exit(0);
			else
				JOptionPane.showMessageDialog(null, (String)this.getValue("Info"));
		}
	}
	
	public MyPanel() {
		Action addAction = new MyAction("Add");
		Action removeFirstAction = new MyAction("Remove First");
		Action removeLastAction = new MyAction("Remove Last");
		Action removeAllAction = new MyAction("Remove All");
		Action quitAction = new MyAction("Quit");

		this.add(new JButton(addAction));
		this.add(new JButton(removeFirstAction));
		this.add(new JButton(removeLastAction));
		this.add(new JButton(removeAllAction));
		this.add(new JButton(quitAction));
	}
}