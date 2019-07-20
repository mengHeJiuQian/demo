package chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 串行的执行任务
 * @author Administrator
 *
 */
public class SingleThreadWebServer {
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while (true) {
			Socket connection = socket.accept();
			// 处理请求(connection);
		}
	}
}
