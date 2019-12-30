package game;

import com.sun.glass.events.KeyEvent;

import java.awt.*;
import java.util.concurrent.Executors;

/**
 * 1. 通过工具获取 .bmp 的截图, 用画图工具打开, 确认像素点的位置.(这里得到血量和蓝量高度分别为 1039 和 1055, 起点和重点分别为 887 和 1057.)
 * 2. 在角色缺血和缺蓝的情况下打印上述像素点的颜色, 记录并并设置为喝药触发颜色
 * 3. 编写喝药程序
 * 4. 打开 PowerShell, 进入到程序文件所在目录, 执行 javac -encoding utf-8 AutoDrink.java 进行编译, 得到 AutoDrink.class
 * 5. 执行 java AutoDrink 启动程序(执行命令的窗口需要用管理员权限打开)
 *
 * @author 文通
 * @since 2019/10/29
 */
public class AutoDrink {

    public static void main(String[] args) throws AWTException {
        // MP 像素点高度固定为 1055, HP 像素点高度固定为 1039, 总长度都是 170(1057-887)
        // 初始化 MP 或 HP 缺失的颜色(通过截图工具获取截图, 通过画图工具获取位置, 通过 sout 打印出颜色)
        // 目标颜色1
        final Color targetColor = new Color(121, 118, 125);
        // 目标颜色2
        final Color targetColor2 = new Color(104, 102, 108);
        // 定义喝红药的任务
        Runnable drinkHp = () -> {
            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                System.out.println("创建 hpRobot 时发生异常！");
            }
            // x = 1057 - 170*(药水/总量)
            int x = (int) Math.floor(1057 - 170 * (6000.0 / 21000));
            System.out.println("x-HP = " + x);
            while (true) {
                Color currentColor = robot.getPixelColor(x, 1039);
                // System.out.println("hpColor: " + currentColor);
                if (targetColor.equals(currentColor)) {
                    robot.keyPress(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_1);
                    // System.out.println("按键 - 1");
                    robot.delay(256);
                } else {
                    robot.delay(512);
                }
            }
        };
        // 定义喝蓝药的任务
        Runnable drinkMp = () -> {
            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                System.out.println("创建 mpRobot 时发生异常！");
            }
            // x = 1057 - 170*(药水/总量)
            int x = (int) Math.floor(1057 - 170 * (6000.0 / 21000));
            System.out.println("x-MP = " + x);
            while (true) {
                Color currentColor = robot.getPixelColor(x, 1055);
                // System.out.println("mpColor: " + currentColor);
                if (targetColor.equals(currentColor) || targetColor2.equals(currentColor)) {
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    // System.out.println("按键 - 2");
                    robot.delay(256);
                } else {
                    robot.delay(512);
                }
            }
        };
        System.out.println("启动自动喝药程序。");
        new Thread(drinkHp).start();
        new Thread(drinkMp).start();
        System.out.println("自动喝药程序已启动。");
    }
}
