package solution;

import javax.swing.JFrame;

public class ServerMain {
	public static void main(String[] args ) {
		ServerFrame frame = new ServerFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		ServerLogic serverLogic = new ServerLogic(frame);
		serverLogic.runServer();
	}
}

