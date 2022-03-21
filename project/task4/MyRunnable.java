import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Map;

public class MyRunnable implements Runnable {
	private final Socket socket;

	public MyRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("Server is accepting new client!");
		try {
			URL url = HTTPAsk.getClientUrl(socket);
			System.out.println("Server has accepted client request.");
			Map<String, Object> tcpInformation = HTTPAsk.getTCPInformation(socket, url);
			System.out.println("Fetching response from host: " + tcpInformation.get("hostname"));
			socket.getOutputStream().write(HTTPAsk.fetchInformationFromServer(tcpInformation));
			System.out.println("Fetching information complete.");
		} catch (IllegalArgumentException e) {
			try {
				socket.getOutputStream().write(HTTPAsk.HTTP400);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (IOException ignored) {

		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
