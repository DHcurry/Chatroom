import DAO.AndDAO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8889);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);

        while (true) {
            System.out.println("连接正常");

            String text = dis.readUTF();
            System.out.println(text);
            String return_text = AndDAO.search(text);

            dos.writeUTF(return_text);
            continue;
        }
    }
}
