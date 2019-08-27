import DAO.AndDAO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
  AndDAO（DAO:(Database Access Object)）
  通过java代码去操作数据库的代码封装
  其中，search为了简化这个作业的设计，就直接将业务代码写在DAO中
  search完成的任务就是到数据库中检索Client发送来的信息，并返回一个response
   数据库的设计就是一个接受和一个应答
*/
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
