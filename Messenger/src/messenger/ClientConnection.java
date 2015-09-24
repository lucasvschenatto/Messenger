package messenger;

import java.net.Socket;


public class ClientConnection implements Runnable {
	private final Socket connection;
	public ClientConnection(Socket socket) {
		this.connection = socket;
	}

	@Override
	public void run() {
		
	}

}
