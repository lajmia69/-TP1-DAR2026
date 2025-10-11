package client3;
import java.net.*;
import java.io.IOException;

public class client3 {
    public static void main(String[] args) {
        String ipServeur = "192.168.56.1";
        int port = 5555;
        Socket socket = null;

        try {
            InetAddress adresseServeur = InetAddress.getByName(ipServeur);
            socket = new Socket(adresseServeur, port);
            System.out.println("Connecté au serveur : " + ipServeur + ":" + port);

            // Traitements...

        } catch (IOException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Erreur fermeture socket client : " + e.getMessage());
                }
            }
        }
    }
}
