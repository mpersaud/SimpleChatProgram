package Client;

import java.net.Socket;

public class ClientThread extends Client implements Runnable {
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    Socket socket;
    @Override
    public void run() {

    }
}
