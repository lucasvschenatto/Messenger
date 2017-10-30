package messenger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port;

	public Server(int port) {
		this.port = port;
	}

	public void serve() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket s = new ServerSocket(port);
		int i = 1;
		while(true){
			Socket socket = s.accept();
			new Thread(new Connection(socket), "Connection" + i++).start();
		}
	}

}
