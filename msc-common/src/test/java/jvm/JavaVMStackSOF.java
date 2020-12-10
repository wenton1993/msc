package jvm;

/**
 * 执行: java -Xss128k jvm.JavaVMStackSOF
 *
 * @author 文通
 * @since 2019/6/3
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable t) {
            System.out.println("Stack Length:" + javaVMStackSOF.stackLength);
            throw t;
        }
    }
}
