package messenger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Connection implements Runnable {
	private Socket socket;
	private BufferedReader in;
	private DataOutputStream out;
	private static final List<DataOutputStream> outputs = new ArrayList<>(); 
	
	public Connection(Socket socket) {
		this.socket = socket;
		try {
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			this.out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		outputs.add(out);
	}

	@Override
	public void run() {
		while(!socket.isClosed())
			processMessage();
	}
	
	private void processMessage(){
		try {
			String message = in.readLine();
			outputs.forEach(output -> sendMessageTo(message, output));
			
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void sendMessageTo(String message, DataOutputStream output) {
		if(output == out)
			return;
		try {
			output.writeBytes(message + "\n");
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}

}
