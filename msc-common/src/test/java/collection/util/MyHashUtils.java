package collection.util;

/**
 * @author 文通
 * @since 2020/1/16
 */
public class MyHashUtils {

    public static void main(String[] args) {
        System.out.println(hash("WenTong", 8));
        System.out.println(hash("OuMinna", 8));
        System.out.println(hash("HuWei", 8));
        System.out.println(hash("PanYu", 8));
        System.out.println(hash("PanHaitao", 8));
        System.out.println(hash("ZiXuan", 8));
    }

    // 计算String的哈希值
    public static int hash(String s, int tableSize) {
        // 初始化hashVal
        int hashVal = 0;
        // 累加hashVal
        for (int i = 0; i < s.length(); i++) {
            hashVal = hashVal * 37 + s.charAt(i);
        }
        // 计算
        hashVal = hashVal % tableSize;
        if (hashVal < 0) {
            hashVal = hashVal + tableSize;
        }
        return hashVal;
    }
}
