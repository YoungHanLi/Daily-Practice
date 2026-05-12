package solution;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame {
	private JTextArea textArea;
	private JScrollPane scrollPane;
	public static final int DEFAULT_WIDTH = 1000;
	public static final int DEFAULT_HEIGHT = 400;
	private ClientLogic clientLogic;

	public ClientFrame() {
		setTitle("Echo Client");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 

		textArea = new JTextArea(8, 40); // JTextArea(int rows, int columns)
		scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);

		clientLogic = new ClientLogic();

		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Connect", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				clientLogic.connectServer(textArea);
			}
		});

		addButton(buttonPanel, "Disconnect", new ActionListener() {
			public void actionPerformed(ActionEvent event) {  
				clientLogic.disconnectServer(textArea);
			}
		});

		// text box 
		JTextField messageField = new JTextField("hello World", 20);
		buttonPanel.add(messageField);

		addButton(buttonPanel, "Send", new ActionListener() {
			public void actionPerformed(ActionEvent event) {  
				clientLogic.sendMessageClienttoServer(messageField, textArea);
			}
		});

		addButton(buttonPanel, "Clear", new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				textArea.setText("");
			}
		});

		addButton(buttonPanel, "Quit", new ActionListener() {
			public void actionPerformed(ActionEvent event) { 
				System.exit(0); }
		}); 

		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void addButton(Container container, String title, ActionListener listener) {
		JButton button = new JButton(title);
		container.add(button);
		button.addActionListener(listener);
	}
}
