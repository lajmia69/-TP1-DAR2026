package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 1234; 
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Je suis un serveur en attente de la connexion d'un client...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Un client est connecté ! Adresse : " + clientSocket.getInetAddress());
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la connexion du serveur : " + e.getMessage());
        }
    }
}
