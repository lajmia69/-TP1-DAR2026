package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // ou remplacer par une adresse IP distante
        int port = 1234;

        try {
            // Première étape : avant connexion
            System.out.println("Je suis un client pas encore connecté...");

            // Tentative de connexion
            try (Socket socket = new Socket(host, port)) {
                System.out.println("Je suis un client connecté !");
                System.out.println("Adresse locale du socket : " + socket.getLocalSocketAddress());
                // Dernière étape : le socket sera fermé automatiquement
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la connexion : " + e.getMessage());
        }
    }
}
