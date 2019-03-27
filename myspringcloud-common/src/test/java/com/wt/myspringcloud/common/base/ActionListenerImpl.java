package com.wt.myspringcloud.common.base;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * ActionListenerImpl
 */
public class ActionListenerImpl implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // 打印时间到控制台
        System.out.println("DateTime: " + LocalDateTime.now());
        // beep()发出一声铃响
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) {
        ActionListener listener = new ActionListenerImpl();
        // 创建定时器
        Timer t = new Timer(10000, listener);
        // 启动定时器
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        // 停止虚拟机 0-正常结束 1-异常结束
        System.exit(0);
    }    

}