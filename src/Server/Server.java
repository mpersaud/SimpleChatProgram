package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {

    private int serverPort;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server(int serverPort){

          this.serverPort = serverPort;
          startServer();

    }
    void startServer(){

        try {
            serverSocket = new ServerSocket(serverPort);
            acceptClients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void acceptClients(){
        //clientThreadList = new ArrayList<ClientThread>();
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Server Started; Waiting for Clients..");
                clientSocket = serverSocket.accept();
                System.out.println(clientSocket.getRemoteSocketAddress()+" connected to server");
                Thread t = new Thread(new ClientThread(clientSocket));
                t.start();

            } catch (IOException e) {
                System.out.println("Accept failed on : "+serverPort);
                //e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Server(Integer.parseInt(args[0]));
    }
}
