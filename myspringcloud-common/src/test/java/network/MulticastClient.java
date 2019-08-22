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
public class MulticastClient {

    public static void main(String[] args) throws IOException {
        try (MulticastSocket socket = new MulticastSocket(4446)) {
            // joinGroup
            InetAddress group = InetAddress.getByName("224.0.113.0");
            socket.joinGroup(group);
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            for (int i = 0; i < 5; i++) {
                socket.receive(packet);
                System.out.println("receive from server: " + new String(packet.getData()));
            }
            // leaveGroup
            socket.leaveGroup(group);
            socket.receive(packet);
            System.out.println("receive from server after leave: " + new String(packet.getData()));
        }
    }
}
