package chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/3/10 21:45
 */
public class ThreadPerTaskServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    // handleRequest(connection);
                }
            };
            new Thread(task).start();
        }

    }

}
