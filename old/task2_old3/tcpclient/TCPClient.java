package tcpclient;
import java.net.*;
import java.io.*;

public class TCPClient {

	private final boolean shutdown;
	private final Integer timeout;
	private final Integer limit;
	private final Socket socket;
    
    public TCPClient(boolean shutdown, Integer timeout, Integer limit) {
    	this.socket = new Socket();
    	this.shutdown = shutdown;
    	this.timeout = timeout;
    	this.limit = limit;
    }

    /**
     * Method: Ask Server.
     * 
     * Create connection with the host with the port.
     * Send client input to server.
     * Read server output of fixed size array and store in 'ByteArrayOutputStream'.
     * Close connection.
     * Return message to the client.
     */
    public byte[] askServer(String hostname, int port, byte [] toServerBytes) throws IOException {
        if (hostname == "" && hostname == null) {
            return new String("Hostname is missing\n").getBytes();
        }
        if (port > 65535) {
            return new String("The port number exceded the interval set by 'java.net.Socket'\n").getBytes();
        }
        try {
            int size = this.limit;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] outputContent = new byte[10];
            int reader = -1;
            // Socket socket = new Socket(hostname, port);
            // this.socket.connect(new InetSocketAddress(hostname, port), this.timeout);
            this.socket.connect(new InetSocketAddress(hostname, port));
            // this.socket.setSoTimeout(this.timeout);
            // this.socket.setReceiveBufferSize(this.limit);
            // this.socket.shutdownInput();
            // System.out.println(this.socket.supportedOptions());
            this.socket.getOutputStream().write(toServerBytes);
            while ((reader = this.socket.getInputStream().read(outputContent)) != -1) {
            System.out.println(reader);
            	// System.out.println(this.socket.getSoTimeout());
            	// System.out.println(this.socket.getReceiveBufferSize());
              outputStream.write(outputContent, 0, reader);
              size = size - reader;
            }
            // System.out.println(this.socket.getSoTimeout());
            this.socket.close();
            return outputStream.toByteArray();
        } catch (ConnectException connectException) {
            return new String("Connection refused\nLook at the message below:\n" + connectException.getMessage() + "\n").getBytes();
        } catch (SocketException socketException) {
            return new String("There was a problem with your socket.\nLook at the message below:\n" + socketException.getMessage() + "\n").getBytes();
        } catch (UnknownHostException hostException) {
            return new String("Problem with Host.\nLook at the message below:\n" + hostException.getMessage() + "\n").getBytes();
        } catch (SocketTimeoutException timeoutException) {
        	return new String("There was Socket Timeout Exception:\n" + timeoutException.getMessage() + "\n").getBytes();
        }catch (IOException ioException) {
            return new String("There was an error for I/O\nLook at the message below:\n" + ioException.getMessage() + "\n").getBytes();
        }
    }
}
