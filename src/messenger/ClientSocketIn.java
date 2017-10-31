package messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSocketIn implements Runnable{
	
	private BufferedReader in;
	private Socket socket;

	public ClientSocketIn(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(!socket.isClosed())
			processMessage();
	}

	private void processMessage(){
		try {
			String message = in.readLine();
			if(message != null)
				System.out.println(message);
		} catch (IOException e) {
			System.exit(0);
		}
	}

}
