package innerclass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

/**
 * TalkingClock 两个成员变量, 用于控制时间间隔和是否发声. 一个成员方法用于启动一个定时器.
 */
public class TalkingClock {

    // 时间间隔
    private int interval;
    // 控制是否发出"哔"的一声
    private boolean beep;

    TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        // 创建一个动作对象, 其中包含了一个对外围类 TalkColck 的对象的引用 this$0
        ActionListener listener = new TimePrinter();
        // 创建一个 Timer 并初始化时间间隔和动作
        Timer timer = new Timer(interval, listener);
        // 启动 Timer
        timer.start();
    }

    /**
     * TimePrinter 是一个实现了 ActionListener 接口的内部类
     */
    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Date: " + new Date());
            // this$0.beep
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    
    }

}