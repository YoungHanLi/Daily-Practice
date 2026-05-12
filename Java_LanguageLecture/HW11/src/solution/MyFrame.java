package solution;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class MyFrame extends JFrame{
	public MyFrame(String title) {
		super(title);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth/2, screenHeight/4);
		setLocation(screenWidth/4, screenHeight/3);
		
		MyPanel panel = new MyPanel();
		this.add(panel);
	}
}