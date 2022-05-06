package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 聊天室的客户端
 */
public class Client {
    /*
        java.net.Socket
        封装了TCP协议的通讯细节，我们基于它就可以与远端计算机建立TCP连接，并基于一对
        输入与输出流的读写完成与远端计算机的数据交互操作。
        可以把Socket想象成"电话"
     */
    private Socket socket;
    /*
        构造器中完成初始化操作
     */
    public Client(){
        try {
            /*
                Socket的构造器:
                Socket(String host,int port)
                参数1:要连接的远端计算机(服务器)的IP地址
                参数2:要连接的运行在远端计算机上的服务端应用程序开启的服务端口
                我们通过IP地址可以找到网络上的服务器计算机，通过端口可以连接到运行在
                该服务器计算上的服务端应用程序。

                并且这个构造器实例化Socket的过程就是与服务端建立连接的过程，如果连接
                失败会抛出异常.
                如果指定的服务端地址与端口不对，那么连接时会抛出异常:
                java.net.ConnectException:Connection refused : connect

             */
            System.out.println("正在连接服务端...");
            socket = new Socket("localhost",8088);
            System.out.println("已连接服务端!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            /*
                Socket提供的方法:
                OutputStream getOutputStream()
                通过socket获取一个字节输出流，使用该输出流写出的字节数据会发送给
                建立连接的远端计算机。而对方也可以通过建立连接的Socket获取输入流
                读取到我们写出的字节。
             */

            //低级流，通过该流写出的字节就发送给了远端计算机
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(osw,true);




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}







