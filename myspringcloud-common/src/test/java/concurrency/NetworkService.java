package concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 文通
 * @since 2019/8/7
 */
class NetworkService implements Runnable {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;
    // 初始化 ServerSocket 和线程池
    public NetworkService(int port, int poolSize) throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 通过创建 Handler 处理 ServerSocket 接收到的 Socket
                pool.execute(new SocketHandler(serverSocket.accept()));
            }
        } catch (IOException ex) {
            pool.shutdown();
        }
    }
}

class SocketHandler implements Runnable {
    private final Socket socket;
    SocketHandler(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        // read and service request on socket
    }
}
