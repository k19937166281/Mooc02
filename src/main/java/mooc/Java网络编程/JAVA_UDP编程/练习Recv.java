package mooc.Java网络编程.JAVA_UDP编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class 练习Recv {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(3000);
        byte[] bytes = new byte[1024];

        DatagramPacket dp = new DatagramPacket(bytes,1024);

        System.out.println("rev 我在等待消息");
        //没接收到消息时 就 一直阻塞
        ds.receive(dp);

        System.out.println("rec 我接受到消息");

        String rev = new String(dp.getData(),0,dp.getLength())
                +"from"+dp.getAddress().getHostAddress()+":"+dp.getPort();
        System.out.println(rev);


        Thread.sleep(1000);

        System.out.println("rev 我要发送消息");
        String send = "helloworld 22";


        DatagramPacket dp2 = new DatagramPacket(send.getBytes(),send.length(),
                InetAddress.getByName("127.0.0.1"),dp.getPort());

        ds.send(dp2);


        System.out.println("rev 我发送消息结束");

        ds.close();
    }
}
