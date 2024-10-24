package io.codeforall.fanstatics;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Connected");

        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream outputStream = clientSocket.getOutputStream();
                switch (in.readLine()) {
                    case "GET /logo.png HTTP/1.1":
                        byte[] bytes = new byte[50000];
                        FileInputStream inputStream = new FileInputStream("www/logo.png");
                        int bytesread = inputStream.read(bytes);
                        out.println("HTTP/1.0 200 Document Follows\r\n " +
                                "Content-Type: image/www/logo.png \r\n\" " +
                                "Content-Length:" + bytesread + " \r\n");
                        outputStream.write(bytes, 0, bytesread);
                break;
                case "GET /index.html HTTP/1.1":
                    bytes = new byte[5000];
                    inputStream = new FileInputStream("www/index.html");
                    bytesread = inputStream.read(bytes);
                    out.println("HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: index.html; charset=UTF-8\r\n" +
                            "Content-Length:" + bytesread + "\r\n");
                    outputStream.write(bytes, 0, bytesread);
                    break;
                default:
                    bytes = new byte[5000];
                    inputStream = new FileInputStream("www/404.html");
                    bytesread = inputStream.read(bytes);
                    out.println("HTTP/1.0 404 Not Found\r\n " +
                            "Content-Type: text.html; charset=UTF-8\r\n " +
                            "Content-Length: " + bytesread + " \r\n");
                    outputStream.write(bytes, 0, bytesread);
                    break;
            }


            }
        }
    }
}