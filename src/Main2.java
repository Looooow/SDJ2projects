import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",5678);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeInt(10);
            while (socket.isConnected()){
               int i = in.readInt();
                System.out.println(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}