import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        DataOutputStream dos = new DataOutputStream(os);
        DataInputStream dis = new DataInputStream(is);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String text = scanner.next();
            dos.writeUTF(text);

        }

    }
}
