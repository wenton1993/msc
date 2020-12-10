package jvm;

/**
 * @author 文通
 * @since 2019/6/3
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行 finalize()");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK == null) {
            System.out.println("死亡");
        } else {
            System.out.println("存活");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK == null) {
            System.out.println("死亡");
        } else {
            System.out.println("存活");
        }
    }
}
