package network;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/**
 * @author 文通
 * @since 2019/8/11
 */
public class QuoteClient {

    public static void main(String[] args) throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {
            // 请求
            byte[] buf = "在吗".getBytes();
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
            System.out.println("send to server: " + new String(packet.getData()) + ", " + Arrays.toString(packet.getData()));
            // 接收响应
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            System.out.println("receive from server: " + new String(packet.getData()) + ", " + Arrays.toString(packet.getData()));
        }
    }
}
