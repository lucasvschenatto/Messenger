package messenger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Client {
	private static OutputStream out;
	private static InputStream in;
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 45678);
		out = socket.getOutputStream();
		in = socket.getInputStream();

	}
	private void send(String message) throws IOException{
		out.write(message.getBytes(Charset.forName("utf-8")));
	}
	private String read() throws IOException{
		List<Byte> byteMessage = new ArrayList<Byte>();
		for(int b = -1; b != -1;){
			b = in.read();
			if (b!=-1)
				byteMessage.add((byte)b);
		}
		byte[] bytes = new byte[byteMessage.size()];
		for ( int i = 0;i<byteMessage.size();i++) {
			bytes[i] = byteMessage.get(i).byteValue();
		}
		return new String(bytes,Charset.forName("utf-8"));
	}
}
