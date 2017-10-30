package messenger;

public class ServerMain {
	public static void main(String argv[]) throws Exception {
			new Server(6789).serve();
	}
}