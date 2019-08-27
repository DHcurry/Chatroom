import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    Socket socket;
    static ServerSocket ss;
    static {
        try {
            ss = new ServerSocket(8888);
        }catch (IOException e ){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        InputStream is;
        DataInputStream dis;

        try {
            socket = ss.accept();
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            while(true) {
                String text = dis.readUTF();
                System.out.println(text);
                continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
