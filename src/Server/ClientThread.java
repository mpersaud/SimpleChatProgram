package Server;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable{
    Socket clientSocket;


    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("clientThread initiated");
        while(true) {
            try {
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine, outputLine;
                
                try {
                    inputLine = in.readLine();
                    System.out.print(inputLine);
                    out.println(inputLine);
                    if (inputLine.equals("Bye"))
                        break;
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
