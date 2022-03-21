package tcpclient;
import java.net.*;
import java.io.*;

public class TCPClient {

    private final boolean shutdown;
    private final Integer timeout;
    private final Integer limit;
    
    public TCPClient(boolean shutdown, Integer timeout, Integer limit) {
        this.shutdown = shutdown;
        this.timeout = timeout;
        this.limit = limit;
    }

    /**
     * TCPClient parameter.
     *
     * TODO add shutdown logic.
     * TODO add timeout logic.
     * TODO add limit logic.
     */
    public byte[] askServer(String hostname, int port, byte [] toServerBytes) throws IOException {
        if (hostname == "" && hostname == null) {
            return new String("Hostname is missing\n").getBytes();
        }
        if (port > 65535) {
            return new String("The port number exceded the interval set by 'java.net.Socket'\n").getBytes();
        }
        try {
            Socket socket = new Socket();
            socket.setReceiveBufferSize(this.limit.intValue());
            socket.connect(new InetSocketAddress(hostname, port), timeout);
            socket.getOutputStream().write(toServerBytes);
            byte[] output = new byte[socket.getReceiveBufferSize()];
            socket.getInputStream().read(output);
            socket.close();
            return output;
        } catch (ConnectException connectException) {
            return new String("Connection refused\nLook at the message below:\n" + connectException.getMessage() + "\n").getBytes();
        } catch (SocketException socketException) {
            return new String("There was a problem with your socket.\nLook at the message below:\n" + socketException.getMessage() + "\n").getBytes();
        } catch (UnknownHostException hostException) {
            return new String("Problem with Host.\nLook at the message below:\n" + hostException.getMessage() + "\n").getBytes();
        } catch (IOException ioException) {
            return new String("There was an error for I/O\nLook at the message below:\n" + ioException.getMessage() + "\n").getBytes();
        }
    }
}
