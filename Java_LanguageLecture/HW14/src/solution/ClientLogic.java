package solution;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientLogic {
	private Socket socket = null;
	private PrintWriter out;
	private InputStream inStream;
	private Scanner scanner;
	private OutputStream outStream;
	
	void connectServer(JTextArea textArea) {
		if (socket == null || socket.isClosed()) {
			try {
				socket = new Socket("localhost", 5001);
				textArea.append("Try to connect " + socket.getInetAddress() + "\n");

				outStream = socket.getOutputStream();
				out = new PrintWriter(outStream
						, true /* autoFlush */);

				inStream = socket.getInputStream();
				scanner = new Scanner(inStream);

				String checkMessage = scanner.nextLine();
				textArea.append(checkMessage + "\n");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			textArea.append("Still Connected\n");
		}
	}
	
	void disconnectServer(JTextArea textArea) {
		if (socket == null ) {
			textArea.append("Not Initiated\n");					
		} else if(!socket.isClosed()) {
			try {
				socket.close();
				textArea.append("Disconnected\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} 
		else {
			textArea.append("Still Disconnected\n");					
		}
	}
	
	void sendMessageClienttoServer(JTextField messageField, JTextArea textArea) {
		if (socket.isClosed()) {
			textArea.append("Failed to Send message: Disconnected\n");
		}
		else {
			String message=messageField.getText();
			if (message.equals(""))
			{
				textArea.append("No Message\n");
			}
			else {
				textArea.append("Send: "+message+"\n");

				out.println(message);
				
				textArea.append("Receive: "+ scanner.nextLine()+"\n");
				
				messageField.setText("");			
				
			}	
		}
	}
}
