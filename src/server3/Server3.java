package server3;
import java.net.*;
import java.io.IOException;

public class Server3 {
    public static void main(String[] args) {
        int port = 5555;
        ServerSocket serveurSocket = null;
        try {
            InetAddress ipLocale = InetAddress.getByName("192.168.56.1");
            serveurSocket = new ServerSocket();
            InetSocketAddress adresse = new InetSocketAddress(ipLocale, port);
            serveurSocket.bind(adresse);
            System.out.println("Serveur démarré sur " + ipLocale.getHostAddress() + ":" + port);

            Socket socket = serveurSocket.accept();
            System.out.println("Connexion reçue de : " + socket.getInetAddress());
            
            // Traitements...

            socket.close();

        } catch (IOException e) {
            System.err.println("Erreur réseau : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (serveurSocket != null) {
                try {
                    serveurSocket.close();
                } catch (IOException e) {
                    System.err.println("Erreur fermeture serveur : " + e.getMessage());
                }
            }
        }
    }
}
