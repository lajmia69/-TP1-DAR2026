package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 1234; 
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Je suis un serveur en attente de la connexion d'un client...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Un client est connecté ! Adresse : " + clientSocket.getInetAddress());
                  InputStream is = clientSocket.getInputStream();
                  DataInputStream dis = new DataInputStream(is);
                  int number = dis.readInt();
                  System.out.println("Le nombre reçu est : " + number);
                   OutputStream os = clientSocket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                //    dos.writeInt(number);
                  System.out.println("je vais rentrer a vous la multiplication par 5");
                    int result = number * 5;
                    dos.writeInt(result);
                    System.out.println("Le résultat a été envoyé au client."+result
                    );
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la connexion du serveur : " + e.getMessage());
        }
    }
}
