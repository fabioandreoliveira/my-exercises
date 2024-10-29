package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {

    private ServerSocket serverSocket;
    private static int port = 4444;
    private final Map<String, PrintWriter> clients = new HashMap<>(); // Armazena os clientes e seus PrintWriters para broadcast

    public ChatServer() {
        try {
            System.out.println("Binding to port " + port);
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                // Aceita nova conexão de cliente
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Inicia uma nova thread para lidar com o cliente
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        } finally {
            close();
        }
    }

    /**
     * Classe interna para lidar com clientes individuais em threads
     */
    private class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Configura fluxo de entrada e saída
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Solicita nome do cliente
                out.println("Enter your name: ");
                clientName = in.readLine();

                // Adiciona o cliente à lista e notifica todos
                synchronized (clients) {
                    clients.put(clientName, out);
                    broadcast("Server", clientName + " has joined the chat.");
                }

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/quit")) {
                        break;
                    } else if (message.startsWith("/whisper")) {
                        handleWhisper(message);
                    } else if (message.startsWith("/list")) {
                        handleList();
                    } else {
                        broadcast(clientName, message);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                // Remove cliente ao sair
                synchronized (clients) {
                    if (clientName != null) {
                        clients.remove(clientName);
                        broadcast("Server", clientName + " has left the chat.");
                    }
                }
                close();
            }
        }

        // Envia uma mensagem para todos os clientes
        private void broadcast(String sender, String message) {
            synchronized (clients) {
                for (PrintWriter writer : clients.values()) {
                    writer.println(sender + ": " + message);
                }
            }
        }

        // Envia uma mensagem privada a um cliente específico
        private void handleWhisper(String message) {
            String[] parts = message.split(" ", 3);
            if (parts.length < 3) {
                out.println("Usage: /whisper <user> <message>");
                return;
            }
            String recipientName = parts[1];
            String privateMessage = parts[2];

            synchronized (clients) {
                PrintWriter recipientWriter = clients.get(recipientName);
                if (recipientWriter != null) {
                    recipientWriter.println("(Whisper) " + clientName + ": " + privateMessage);
                    out.println("(Whisper to " + recipientName + ") " + privateMessage);
                } else {
                    out.println("User " + recipientName + " not found.");
                }
            }
        }

        // Lista todos os clientes conectados
        private void handleList() {
            synchronized (clients) {
                out.println("Connected users: " + String.join(", ", clients.keySet()));
            }
        }

        // Fecha a conexão do cliente
        private void close() {
            try {
                if (socket != null) socket.close();
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                System.out.println("Error closing client connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }

    // Fecha o servidor e todas as conexões
    public void close() {
        try {
            if (serverSocket != null) {
                System.out.println("Closing server socket");
                serverSocket.close();
            }
        } catch (IOException ex) {
            System.out.println("Error closing server: " + ex.getMessage());
        }
    }
}



