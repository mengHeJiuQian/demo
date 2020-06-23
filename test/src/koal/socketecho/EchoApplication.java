package koal.socketecho;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/19 9:36
 * 版本：1.0
 * 内容描述：试题二
 *
 * 实现要求：
 * 1、根据代码片段实现一个简单的SOCKET ECHO程序；
 * 2、接受到客户端连接后，服务端返回一个欢迎消息;
 * 3、接受到"bye"消息后， 服务端返回一个结束消息，并结束当前连接;
 * 4、支持通过telnet连接本服务端，并且可正常运行；
 * 5、注意代码注释书写。
 *
 */

/**
 * 先启动EchoServer中的main方法
 * 再启动EchoClient中的main方法，在EchoClient运行的控制台上输入“bye”即结束。
 *
 * 注意：
 * BufferedWriter 使用“\n”作为一行的结束符。否则一直处在write操作。
 * 调试过程发现“\r\n”、“\n”、“\r”都可使用。“\n”通常作为换行符，故用它。
 */
public class EchoApplication {

    public static int port = 12345;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(s);


//        final int listenPort = 12345;

        // 启动服务端
//        EchoServer server = new EchoServer(listenPort);
//        server.startService();

        // 启动客户端
//        EchoClient client = new EchoClient(listenPort);
//        client.startService();

        // 在控制台输入，服务端直接原文返回输入信息
        // 控制台结果示例：
        /**
         2020-03-31 16:58:44.049 - Welcome to My Echo Server.(from SERVER)

         Enter: hello!
         2020-03-31 16:58:55.452 - hello!(from SERVER)

         Enter: this is koal.
         2020-03-31 16:59:06.565 - this is koal.(from SERVER)

         Enter: what can i do for you?
         2020-03-31 16:59:12.828 - what can i do for you?(from SERVER)

         Enter: bye!
         2020-03-31 16:59:16.502 - Bye bye!(from SERVER)
         */
    }

}


