package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1"; 
        int port = 1234;

        try {
           
            System.out.println("Je suis un client pas encore connecté...");

      
            try (Socket socket = new Socket(host, port)) {
                System.out.println("Je suis un client connecté !");
                System.out.println("Adresse locale du socket : " + socket.getLocalSocketAddress());
          
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la connexion : " + e.getMessage());
        }
    }
}
