package Server;

import Client.ClientThread;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends JFrame {

    private int serverPort;
//    private JTextField userText;
//    private JTextArea chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket serverSocket;
    private Socket connection;
    private List clientThreadList;

    public Server(int serverPort){

          this.serverPort = serverPort;
          startServer();
//        super("Messenger");
//        userText = new JTextField();
//        userText.setEditable(false);
//        userText.addActionListener(l ->userText.setText(""));
//        this.add(userText,BorderLayout.NORTH);
//        chatWindow = new JTextArea();
//        Button btn = new Button("Send");
//        add(new JScrollPane(chatWindow),BorderLayout.CENTER);
//        //bottomPane.add(btn);
//        add(btn,BorderLayout.SOUTH);
//
//        setSize(300,300);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setVisible(true);
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
        clientThreadList = new ArrayList<ClientThread>();
        while (true) {
            try {
                connection = serverSocket.accept();
                ClientThread client = new ClientThread(connection);
                Thread t = new Thread(client);
                clientThreadList.add(client);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new Server(5000);


    }
}
