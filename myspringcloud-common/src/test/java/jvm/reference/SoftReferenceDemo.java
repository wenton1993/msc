package jvm.reference;

import java.lang.ref.SoftReference;

/**
 * 在 src\test\java 下打开终端执行：java -Xmx200m -XX:+PrintGC jvm.reference.SoftReferenceDemo
 * @author 文通
 * @since 2019/8/19
 */
public class SoftReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        // 100M
        byte[] data = new byte[100 * 1024 * 1024];
        // 将缓存数据用软引用持有
        SoftReference<byte[]> cacheRef = new SoftReference<>(data);
        // 将缓存数据的强引用去除
        data = null;
        System.out.println("第一次GC前" + data);
        System.out.println("第一次GC前" + cacheRef.get());
        // 进行一次GC后查看对象的回收情况
        System.gc();
        // 等待GC
        Thread.sleep(1000);
        System.out.println("第一次GC后" + data);
        System.out.println("第一次GC后" + cacheRef.get());
        // 分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData = new byte[120 * 1024 * 1024];
        System.out.println("分配后" + data);
        System.out.println("分配后" + cacheRef.get());// 打印 null，没有发生内存溢出的错误，说明 data 已经被回收
    }
}
