package solution;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerFrame extends JFrame {
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private final int DEFAULT_WIDTH = 500;
	private final int DEFAULT_HEIGHT = 400;

	public ServerFrame() {
		setTitle("Echo Server");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 

		textArea = new JTextArea(8, 40); // JTextArea(int rows, int columns)
		scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void printMessageServerUI(String message) {
		this.textArea.append(message);
	}
}
