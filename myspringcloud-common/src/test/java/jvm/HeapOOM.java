package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行: java -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError jvm.HeapOOM
 *
 * @author 文通
 * @since 2019/6/3
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
