package solution;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerLogic {
	final private ServerFrame serverFrame;
	public ServerLogic(ServerFrame serverFrame) {
		this.serverFrame = serverFrame;
	}
	public void runServer()
	{
		try {
			ServerSocket s = new ServerSocket(5001);

			while( !s.isClosed() ) {
				Socket incoming = s.accept( );
				InetAddress clientAddress = incoming.getInetAddress() ;
				this.serverFrame.printMessageServerUI("Connected from " + clientAddress.getHostAddress()+"\n");
				try {
					InputStream inStream = incoming.getInputStream();
					OutputStream outStream = incoming.getOutputStream();

					PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
					out.println("Connection Established");

					Scanner scanner = new Scanner(inStream);
					while(!incoming.isClosed() && scanner.hasNextLine()) {
						String message = scanner.nextLine();
						this.serverFrame.printMessageServerUI("Read: "+message+"\n");
						out.println("Hi! " + message); // echo it back to the client
						this.serverFrame.printMessageServerUI("Write: Hi! "+message+"\n");	
					}
				} 
				finally {
					incoming.close();
				}
				if( incoming.isClosed()) {
					this.serverFrame.printMessageServerUI("Disconnected\n");
				}
			}
		}
		catch (IOException e) { 
			e.printStackTrace(); 	
		}
	}
}
