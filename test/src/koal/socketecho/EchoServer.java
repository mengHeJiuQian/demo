package koal.socketecho;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/19 10:33
 * 版本：1.0
 * 内容描述：
 */
public class EchoServer {

    private final ServerSocket serverSocket;

    public EchoServer(int listenPort) throws IOException {
        serverSocket = new ServerSocket(listenPort);
    }

    public void startService() throws IOException {
        // 服务端监听一个端口号，用于通信
        Socket client = serverSocket.accept();
        handleClientRequest(client);
    }

    private void handleClientRequest(Socket socket) throws IOException {

        // 输入字节流转成输入字符缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String clientData;

        // bufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("Welcome to My Echo Server.(from SERVER)\n");
        bw.flush();
        while (true) {
            clientData = br.readLine();
            System.out.println("clientdata:" + clientData);
            if ("bye".equalsIgnoreCase(clientData)) {
                clientData = "bye bye";

                bw.write(clientData + "(from SERVER)\n");
                bw.flush();
                close(bw, br, serverSocket);
                break;
            }
            bw.write(clientData + "(from SERVER)\n");
            bw.flush();
        }

    }

    public void close(BufferedWriter bw, BufferedReader br, ServerSocket serverSocket) throws IOException {
        if (bw != null) {
            bw.close();
        }
        if (br != null) {
            br.close();
        }
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
    public static void main(String[] args) throws IOException {
        // 启动服务端
        EchoServer server = new EchoServer(EchoApplication.port);
        server.startService();
    }
}
