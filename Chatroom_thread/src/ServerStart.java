import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerStart {
    public static void main(String[] args) {
        ExecutorService es  = Executors.newFixedThreadPool(3);
        Server server1 = new Server();
        Server server2 = new Server();
        es.submit(server1);
        es.submit(server2);
    }
}
