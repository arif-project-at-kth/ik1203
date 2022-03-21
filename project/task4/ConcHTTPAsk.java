import java.io.IOException;
import java.net.ServerSocket;

public class ConcHTTPAsk {
    /**
     * TODO Create one thread for each client.
     */
    public static void main(String[] args) throws IOException {
        Integer port = getPort(args);
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            System.out.println("Starting new thread for client");
            new Thread(new MyRunnable(serverSocket.accept())).start();
        }
    }
	private static Integer getPort(String[] args) {
		  if (args.length == 0) {
        System.out.println("Forgot to add port number.");
        System.exit(0);
      }
      return Integer.parseInt(args[0]);
    }
}
