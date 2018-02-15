package Client;

import java.io.IOException;
import java.net.Socket;

public class Client {

        //private String userName;
        public static void main(String[] args) {

            try {
                Socket connection = new Socket("localhost",5000);
                System.out.println(connection.getRemoteSocketAddress());

                    Thread t = new Thread(new ServerThread(connection));
                    t.start();
                    //t.sleep(500);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

