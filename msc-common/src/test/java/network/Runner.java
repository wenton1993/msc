package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;

/**
 * @author 文通
 * @since 2019/8/11
 */
public class Runner {

    public static void main(String[] args) throws IOException {
        // 获取本机所有网络接口
        // Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        // 获取指定的网络接口
        NetworkInterface nif = NetworkInterface.getByName("wlan1");
        Enumeration<InetAddress> nifAddresses = nif.getInetAddresses();
        Enumeration<NetworkInterface> subInterfaces = nif.getSubInterfaces();
        Socket socket = new Socket();
        if (nifAddresses.hasMoreElements()) {
            socket.bind(new InetSocketAddress(nifAddresses.nextElement(), 0));
            socket.connect(new InetSocketAddress("127.0.0.1", 4445));
        }
    }
}
