package game;

import com.sun.glass.events.KeyEvent;

import java.awt.*;

/**
 * 林之灵在日蚀地带自动攻击的脚本
 *
 * @author 文通
 * @since 2019/11/13
 */
public class AutoAttack {

    public static void main(String[] args) {
        Runnable autoAttack = () -> {
            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                System.out.println("创建 hpRobot 时发生异常！");
            }
            while (true) {
                move(robot, KeyEvent.VK_LEFT);
                pressKey(robot, KeyEvent.VK_X);
                pressKey(robot, KeyEvent.VK_D);
                attack(robot, KeyEvent.VK_F);

                move(robot, KeyEvent.VK_RIGHT);
                pressKey(robot, KeyEvent.VK_X);
                pressKey(robot, KeyEvent.VK_D);
                attack(robot, KeyEvent.VK_F);
            }
        };
        new Thread(autoAttack).start();
    }
    // 左右移动
    public static void move(Robot robot, int keyEvent) {
        robot.keyPress(keyEvent);
        robot.delay(1200);
        robot.keyRelease(keyEvent);
    }
    // 按一个键，用于释放技能
    public static void pressKey(Robot robot, int keyEvent) {
        robot.keyPress(keyEvent);
        robot.keyRelease(keyEvent);
        robot.delay(1500);
    }
    // 攻击
    public static void attack(Robot robot, int keyEvent) {
        for (int i = 0; i < 64; i++) {
            robot.keyPress(keyEvent);
            robot.keyRelease(keyEvent);
            robot.delay(200 + (i / 10));
        }
    }
}
