package io.codeforall.fanstatics;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServerWWW {

    public void receiveMes() throws IOException {


        ServerSocket serverSocket = new ServerSocket(60000);
        Socket clientSocket = serverSocket.accept();

        OutputStream out = clientSocket.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

       // System.out.println(in.readLine());
        String linkAddress = in.readLine().substring(4);
        System.out.println(linkAddress);
        Path of = Path.of("www/index.html");

        String htmlPage = Files.readString(of);
        byte[] pageToBytes = htmlPage.getBytes();


        String httpOK = "HTTP/1.0 200 OK\r\n";
        String httpType = "Content-Type: text/html; charset=UTF-8\r\n";
        String httpLength = "Content-Length: " + pageToBytes.length + "\r\n";
        String httpEnd = "\r\n";


        if(linkAddress.equals("/index.html HTTP/1.1") || linkAddress.equals("/ HTTP/1.1"))
        {
            out.write(httpOK.getBytes());
            out.write(httpType.getBytes());
            out.write(httpLength.getBytes());
            out.write(httpEnd.getBytes());
            out.write(pageToBytes);
            out.flush();
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }


    }
}
