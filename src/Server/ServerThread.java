package Server;

import java.net.Socket;

public class ServerThread extends Server implements Runnable {
    public ServerThread(int ServerPoint) {
        super(ServerPoint);
        this.socket = socket;
    }



    Socket socket;
    @Override
    public void run() {

    }
}
