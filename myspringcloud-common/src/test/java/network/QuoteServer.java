package network;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 * @author 文通
 * @since 2019/8/11
 */
public class QuoteServer {

    public static void main(String[] args) throws IOException {
        try (DatagramSocket socket = new DatagramSocket(4445)) {
            // 接收请求
            byte[] buf = new byte[6];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            System.out.println("receive from client: " + new String(packet.getData()) + ", " + Arrays.toString(packet.getData()));
            // 响应
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            buf = "收到".getBytes();
            packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            System.out.println("result to client: " + new String(packet.getData()) + ", " + Arrays.toString(packet.getData()));
        }
    }
}