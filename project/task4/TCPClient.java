import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	private static final int BUFFER_SIZE = 1024;
	private final boolean shutdown;
	private final Integer timeout;
	private final Integer limit;

	public TCPClient(boolean shutdown, Integer timeout, Integer limit) {
		this.shutdown = shutdown;
		this.timeout = timeout;
		this.limit = limit == null ? 0 : limit;
	}

	public byte[] askServer(String hostname, int port, byte[] toServerBytes) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Socket socket = null;
		try {
			socket = new Socket(hostname, port);
			int limit = this.limit > BUFFER_SIZE || this.limit == 0 ? BUFFER_SIZE : this.limit;
			byte[] outputContent = new byte[BUFFER_SIZE];
			int reader;
			if (this.timeout != null) socket.setSoTimeout(this.timeout);
			socket.getOutputStream().write(toServerBytes);
			if (this.shutdown) socket.shutdownOutput();
			int counter = this.limit == 0 ? socket.getReceiveBufferSize() : this.limit;
			while (counter > 0 && (reader = socket.getInputStream().read(outputContent, 0, limit)) != -1) {
				counter -= reader;
				if (reader == 0) break;
				outputStream.write(outputContent, 0, reader);
			}
			return outputStream.toByteArray();
		} catch (UnknownHostException e) {
			throw new UnknownHostException();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		} catch (IOException ioException) {
			socket.shutdownInput();
		}
		return outputStream.toByteArray();
	}
}