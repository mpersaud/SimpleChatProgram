package Client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {

    Socket serverSocket;

    public ServerThread(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        System.out.println("ServerThread initiated");
        try {
            PrintWriter out =
                    new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(serverSocket.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String fromServer="Server";
            String fromUser=" ";
            out.println(fromUser);
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
