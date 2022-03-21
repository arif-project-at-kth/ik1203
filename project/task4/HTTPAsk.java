import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HTTPAsk {
	private static final byte[] HTTP200 =
			"HTTP/1.1 200 OK\nConnection: close\nContent-Type: text/plain;\n\n".getBytes(StandardCharsets.UTF_8);
	public static final byte[] HTTP400 =
			"HTTP/1.1 400 Bad Request\nConnection: close\nContent-Type: text/plain;\n\n".getBytes(StandardCharsets.UTF_8);
	private static final byte[] HTTP404 =
			"HTTP/1.1 404 Not Found\nConnection: close\nContent-Type: text/plain;\n\n".getBytes(StandardCharsets.UTF_8);
	private static final String HTTP1 = "HTTP/1";

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(getPort(args));
		while (true) {
			Socket clientSide = serverSocket.accept();
			System.out.println("Server is accepting new client!");
			try {
				URL url = getClientUrl(clientSide);
				System.out.println("Server has accepted client request.");
				Map<String, Object> tcpInformation = getTCPInformation(clientSide, url);
				System.out.println("Fetching response from host: " + tcpInformation.get("hostname"));
				clientSide.getOutputStream().write(fetchInformationFromServer(tcpInformation));
				System.out.println("Fetching information complete.");
			} catch (IllegalArgumentException e) {
				clientSide.getOutputStream().write(HTTP400);
			} catch (IOException e) {

			} finally {
				clientSide.close();
			}
		}
	}

	public static Map<String, Object> getTCPInformation(Socket clientSide, URL url) throws IOException {
		Map<String, Object> tcpInformation = extractTCPInformationFrom(url);
		if (!tcpInformation.containsKey("hostname") || !tcpInformation.containsKey("port")) {
			clientSide.getOutputStream().write(HTTP400);
			clientSide.close();
			System.exit(1);
		}
		return tcpInformation;
	}

	public static URL getClientUrl(Socket clientSide) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(fetchClientRequest(clientSide));
		return getUrl(outputStream);
	}

	public static byte[] fetchInformationFromServer(Map<String, Object> tcpInformation) throws IOException {
		try {
			TCPClient tcpClient = new TCPClient((Boolean) tcpInformation.getOrDefault("shutdown", false),
					(Integer) tcpInformation.getOrDefault("timeout", null), (Integer) tcpInformation.getOrDefault(
							"limit", null));
			byte[] result = tcpClient.askServer((String) tcpInformation.get("hostname"), (Integer) tcpInformation.get(
					"port"), (byte[]) tcpInformation.getOrDefault("string", new byte[0]));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			output.write(HTTP200);
			output.write(result);
			return output.toByteArray();
		} catch (UnknownHostException e) {
			System.out.println(e.getLocalizedMessage());
			return HTTP404;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getLocalizedMessage());
			return HTTP400;
		}
	}

	private static Map<String, Object> extractTCPInformationFrom(URL url) {
		Map<String, Object> tcpInformation = new HashMap<>();
		for (String var : url.getQuery().split("&")) {
			if (var.startsWith("hostname=")) {
				tcpInformation.put("hostname", var.split("=")[1]);
			} else if (var.startsWith("port=")) {
				tcpInformation.put("port", Integer.valueOf(var.split("=")[1]));
			} else if (var.startsWith("shutdown=")) {
				tcpInformation.put("shutdown", Boolean.parseBoolean(var.split("=")[1]));
			} else if (var.startsWith("limit=")) {
				tcpInformation.put("limit", Integer.valueOf(var.split("=")[1]));
			} else if (var.startsWith("timeout=")) {
				tcpInformation.put("timeout", Integer.valueOf(var.split("=")[1]));
			} else if (var.startsWith("string=")) {
				tcpInformation.put("string", var.split("=")[1].getBytes(StandardCharsets.UTF_8));
			}
		}
		return tcpInformation;
	}

	private static URL getUrl(ByteArrayOutputStream outputStream) throws IOException {
		String protocol = "http://";
		String[] pathAndQueryAndProtocol = outputStream.toString().split("\n")[0].split(" ");
		if (pathAndQueryAndProtocol[1].contains("/favicon.ico")) {
			throw new IOException();
		}
		if (!pathAndQueryAndProtocol[0].startsWith("GET")) {
			System.out.println("Bad Request!");
			throw new IllegalArgumentException();
		}
		if (!pathAndQueryAndProtocol[1].contains("/ask?")) {
			System.out.println("Client request missing '/ask' path in request.\nClosing client socket.");
			throw new IllegalArgumentException();
		}
		if (!pathAndQueryAndProtocol[2].startsWith(HTTP1)) {
			System.out.println("Bad protocol!");
			throw new IllegalArgumentException();
		}
		String pathAndQuery = pathAndQueryAndProtocol[1];
		String hostname = outputStream.toString().split("\r\n")[1].split(" ")[1];
		return new URL(protocol + hostname + pathAndQuery);
	}

	private static byte[] fetchClientRequest(Socket clientSide) throws IOException {
		byte[] fromClient = new byte[1024];
		int reader = clientSide.getInputStream().read(fromClient);
		if (reader <= 0) {
			clientSide.getOutputStream().write(HTTP400);
			clientSide.close();
			System.exit(1);
		}
		return fromClient;
	}

	private static int getPort(String[] args) {
		if (args.length == 0) {
			System.out.println("Forgot to add port number.");
			System.exit(0);
		}
		return Integer.parseInt(args[0]);
	}
}

