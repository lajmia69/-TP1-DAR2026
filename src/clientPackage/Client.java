package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String host = "127.0.0.1";
            int port = 1234;

            try {
                System.out.println("Je suis un client pas encore connecté...");

                try (Socket socket = new Socket(host, port)) {
                    System.out.println("Je suis un client connecté !");
                    System.out.println("Adresse locale du socket : " + socket.getLocalSocketAddress());
                    System.out.println("donner un nombre");
                    int number = scanner.nextInt();
                    OutputStream os = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeInt(number);
                    System.out.println("element envoyee");
                    System.out.println("je vais recevoir le resultat de la multiplication par 5");
                     InputStream is = socket.getInputStream();
                     DataInputStream dis = new DataInputStream(is);
                     int result = dis.readInt();
                     System.out.println("le nombre recu est " + result);

                }

            } catch (IOException e) {
                System.err.println("Erreur lors de la connexion : " + e.getMessage());
            }
        }
    }
}
