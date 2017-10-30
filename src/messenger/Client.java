package messenger;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket;
	
	private String host;
	private int port;
	
	public Client(String host, int port){
		this.host = host;
		this.port = port;
				
	}

	public void connect() throws UnknownHostException, IOException {
		socket = new Socket(host,port);
		
		new Thread(new ClientSocketIn(socket), "Client IN").start();
		new Thread(new ClientSocketOut(socket), "Client OUT").start();
	}

}
