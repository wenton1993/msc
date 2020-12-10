package reflection;

/**
 * @author 文通
 * @since 2020/1/20
 */
public class TypeTester {

    public static void main(String[] args) {
        // 打印数据的类型
        int[] ints = {1, 2, 3};
        System.out.println(ints.getClass());// [ 表示这是一个一维数组，I 表示数组元素是 int 类型的
    }
}
