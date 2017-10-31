package messenger;

import java.io.IOException;
import java.net.ConnectException;
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
		do{
			try{
				socket = new Socket(host,port);				
			}catch(ConnectException e){}
		} while(socket == null);
		System.out.printf("Connection stablished to %s:%d",host,port);
		
		new Thread(new ClientSocketIn(socket), "Client IN").start();
		new Thread(new ClientSocketOut(socket), "Client OUT").start();
	}

}
