package Server;

public class MainServer {
    public static void main(String[] args) {
        ServerSideSocket socket = new ServerSideSocket();
        while (true){
            System.out.println("Waiting for client...");
            socket.createClient();
            System.out.println("Connected");
        }
    }

}
