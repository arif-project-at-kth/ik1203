import java.net.*;
import java.io.*;
import tcpclient.TCPClient;

public class TCPAsk {
    /*
     * Usage: explain how to use the program, then exit with failure status
     */
    private static void usage() {
        System.err.println("Usage: TCPAsk [options] host port <data to server>");
        System.err.println("Possible options are:");
        System.err.println("    --shutdown");
        System.err.println("    --timeout <milliseconds>");
        System.err.println("    --limit <bytes>");
        System.exit(1);
    }

    /*
     * Main program. Parse arguments on command line and call TCPClient
     */
    public static void main( String[] args) {
        boolean shutdown = false;
        Integer timeout = null;
        Integer limit = null;
        String hostname = null;
        int port = 0;
        byte[] userInputBytes = new byte[0];
        
        try {
            int argindex = 0;

            // Options first. Loop through command line arguments and look for options.
            while (argindex < args.length && args[argindex].startsWith("--")) {
                if (args[argindex].equals("--shutdown")) {
                    // Consume next argument as timeout
                    shutdown = true;
                }

                if (args[argindex].equals("--timeout")) {
                    // Consume next argument as timeout
                    argindex += 1;
                    timeout = Integer.parseInt(args[argindex]);
                }
                if (args[argindex].equals("--limit")) {
                    // Consume next argument as limit
                    argindex += 1;
                    limit = Integer.parseInt(args[argindex]);
                }
                argindex++;
            }

            // Then mandatory command line arguments: hostname and port number
            hostname = args[argindex++];
            port = Integer.parseInt(args[argindex++]);

            // Remaining arguments, if any, are string to send to server
            if (argindex < args.length) {
                // Collect remaining arguments into a string with single space as separator
                StringBuilder builder = new StringBuilder();
                boolean first = true;
                while (argindex < args.length) {
                    if (first)
                        first = false;
                    else
                        builder.append(" ");
                    builder.append(args[argindex++]);
                }
                builder.append("\n");
                userInputBytes = builder.toString().getBytes();
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            // Exceeded array while parsing command line, or could
            // not convert port number argument to integer -- tell user
            // how to use the program
            usage();
        }

        try {
            TCPClient tcpClient = new tcpclient.TCPClient(shutdown, timeout, limit);
            byte[] serverBytes  = tcpClient.askServer(hostname, port, userInputBytes);
            String serverOutput = new String(serverBytes);
            System.out.printf("%s:%d says:\n%s", hostname, port, serverOutput);
            // For non-empty strings, make a linebreak if there isn't one the end of the string
            if (serverOutput.length() > 0 && !serverOutput.endsWith("\n"))
                System.out.println();
        } catch(IOException ex) {
            System.err.println(ex);
            System.exit(1);
        }
    }
}

