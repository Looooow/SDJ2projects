package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSideSocket {
    private final int Port = 5678;
    private ServerSocket welcomeSocket;

    public ServerSideSocket() {
        try {
            welcomeSocket = new ServerSocket(Port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createClient(){
        try {
            new Thread(new ClientHandler(welcomeSocket.accept())).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
