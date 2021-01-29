package mooc.Java网络编程.JAVA_UDP编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class 练习Send {
    public static void main(String[] args) throws Exception {


        DatagramSocket ds = new DatagramSocket();
        String str = " hello world 1111";


        DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(),InetAddress.getByName("127.0.0.1"),3000);

        System.out.println("send 我在发送消息");
        ds.send(dp);

        System.out.println("send 我发送消息结束");

        Thread.sleep(1000);

        System.out.println("send 我在等待消息");
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,1024);
        ds.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData()));
        System.out.println("from"+datagramPacket.getAddress().getHostAddress()+":"+datagramPacket.getPort());

        System.out.println("send 我等待消息结束");
        ds.close();
    }
}
