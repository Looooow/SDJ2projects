package Server;

import model.Timer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private boolean running;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        running = true;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            int second;
            System.out.println("We here");
            second = in.readInt();
            Timer timer = new Timer(second);
            new BroadCastHandler(out, timer);
            new Thread(timer).start();
            while (true) {
                if (timer.getSecond() == 1) {
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
