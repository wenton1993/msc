package socket;

import org.apache.commons.io.input.ReaderInputStream;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author 文通
 * @since 2019/6/4
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {
        /*try (Socket socket = new Socket("time-a.nist.gov", 13)) {
            // Scanner
            Scanner in = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8.toString());
            while (in.hasNext()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }*/

        try (Socket socket = new Socket("time-a.nist.gov", 13);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }

    }
}
