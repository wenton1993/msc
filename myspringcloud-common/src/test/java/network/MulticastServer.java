package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * @author 文通
 * @since 2019/8/11
 */
public class MulticastServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        try (MulticastSocket socket = new MulticastSocket()) {
            // 多播IP 224.0.0.0 - 239.255.255.255
            InetAddress group = InetAddress.getByName("224.0.113.0");
            byte[] buf = "大家在吗".getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
            while (true) {
                socket.send(packet);
                System.out.println("multicast to clients: " + new String(packet.getData()));
                Thread.sleep(3000);// 每隔一段时间多播一次
            }
        }
    }
}
