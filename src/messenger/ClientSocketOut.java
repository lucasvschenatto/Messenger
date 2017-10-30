package messenger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSocketOut implements Runnable{
	private BufferedReader console;
	private DataOutputStream out;
	private Socket socket;
	public ClientSocketOut(Socket socket){
		this.socket = socket;
		console = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run() {
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e){
			e.printStackTrace();
		}
		while(!socket.isClosed())
			processMessage();
	}

	private void processMessage(){
		String message;
		try{
			message = console.readLine();
			out.writeBytes(message + "\n");
		} catch (IOException e) {}
	}
}
