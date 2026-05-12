package solution;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceBallFrame extends JFrame{
	public BounceBallFrame() {
		setTitle("Thread BallBounce");
		setSize(DEFAULT_WIDTH, DEFUALT_HEIGHT);
		
		ballPanel = new BallPanel();
		add(ballPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout());
		addButton(buttonPanel, "Add1", new ActionListener() {
			public void actionPerformed(ActionEvent event) {addBall();}
		});
		addButton(buttonPanel, "Add2", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addBall();
				try {
					Thread.sleep(100);
				}catch (InterruptedException e) {}
				addBall();
			}
		});
		addButton(buttonPanel, "Close", new ActionListener() {
			public void actionPerformed(ActionEvent event) {System.exit(0);}
		});
		
		JMenu speedMenu = new JMenu("Speed");
		speedMenu.add(new AbstractAction("Faster") {
			public void actionPerformed(ActionEvent event) {
				decreaseDelay();
			}
		});
		speedMenu.add(new AbstractAction("Slower") {
			public void actionPerformed(ActionEvent event) {
				increaseDelay();
			}
		});
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(speedMenu);
	}
	public void addButton(Container container, String title, ActionListener listener) {
		JButton button = new JButton(title);
		container.add(button);
		button.addActionListener(listener);
	}
	public void addBall() {
		Ball ball = new Ball();
		ballPanel.add(ball);
		Runnable r = new BallRunnable(ball, ballPanel, delay);
		Thread t = new Thread(r);
		t.start();
	}
	public void decreaseDelay() {
		if(delay != 1)
			delay /= 2;
	}
	public void increaseDelay() {
		delay *= 2;
	}

	private BallPanel ballPanel;
	private JMenuBar menuBar;
	private int delay = 4;
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFUALT_HEIGHT = 350;
}
