package messenger;

public class ClientMain {
	public static void main(String argv[]) throws Exception {
		new Client("localhost", 6789).connect();
	}
}