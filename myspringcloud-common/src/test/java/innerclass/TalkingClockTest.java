package innerclass;

import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

/**
 * TalkingClockTest
 */
public class TalkingClockTest {

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    public void test() {
        TalkingClock listener = new TalkingClock(1000, true);
        listener.new TimePrinter();
    }

}