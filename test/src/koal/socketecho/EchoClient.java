package koal.socketecho;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/19 10:34
 * 版本：1.0
 * 内容描述：
 */
public class EchoClient {
    // 客户端socket
    private final Socket socket;

    public EchoClient(int listenPort) throws IOException {
        socket = new Socket("localhost", listenPort);
    }

    public void startService() throws IOException {

        Scanner scanner = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String info;
        while (true) {
            info = br.readLine();
            System.out.println(info);

            if ("bye bye(from SERVER)".equalsIgnoreCase(info)) {
                break;
            }

            // 从控制台输入的信息
            System.out.print("Enter：");
            String inputLine = scanner.nextLine() + "\n";
            bw.write(inputLine);
            bw.flush();
        }
        close(bw, br, socket);
    }

    public void close(BufferedWriter bw, BufferedReader br, Socket socket) throws IOException {
        if (bw != null) {
            bw.close();
        }
        if (br != null) {
            br.close();
        }
        if (socket != null) {
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        // 启动客户端
        EchoClient client = new EchoClient(EchoApplication.port);
        client.startService();
    }
}
