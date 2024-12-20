package io.codeforall.bootcamp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Multi-threaded simple web server implementation
 */
public class WebServer {

    private static final Logger logger = Logger.getLogger(WebServer.class.getName());

    public static final String DOCUMENT_ROOT = "www/";
    public static final int DEFAULT_PORT = 8090;

    private ServerSocket bindSocket = null;

    public static void main(String[] args) {

        try {

            int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

            WebServer webServer = new WebServer();
            webServer.listen(port);

        } catch (NumberFormatException e) {

            System.err.println("Usage: WebServer [PORT]");
            System.exit(1);

        }
    }

    private void listen(int port) {

        try {

            bindSocket = new ServerSocket(port);
            logger.log(Level.INFO, "server bind to " + getAddress());
            dispatch(bindSocket);

        } catch (IOException e) {

            logger.log(Level.SEVERE, "could not bind to port " + port);
            logger.log(Level.SEVERE, e.getMessage());
            System.exit(1);

        }
    }

    private void dispatch(ServerSocket bindSocket) {

        while (true) {

            try {

                // accepts client connections and instantiates client dispatchers
                ClientDispatcher clientDispatcher = new ClientDispatcher(bindSocket.accept());

                logger.log(Level.INFO, "new connection from " + clientDispatcher.getAddress());


                ExecutorService fixedPool = Executors.newFixedThreadPool(4);

                for(int i = 0; i < 10; i++){
                    fixedPool.submit(clientDispatcher);
                }
                // launch the client thread
                //Thread clientThread = new Thread(clientDispatcher);
                //clientThread.start();

            } catch (IOException e) {

                logger.log(Level.SEVERE, e.getMessage());

            }
        }
    }

    private String getAddress() {

        if (bindSocket == null) {
            return null;
        }

        return bindSocket.getInetAddress().getHostAddress() + ":" + bindSocket.getLocalPort();
    }

}
