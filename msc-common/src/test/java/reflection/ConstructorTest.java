package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 文通
 * @since 2019/6/25
 */
public class ConstructorTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        // ConstructorDemo constructorDemo = constructorDemoClass.newInstance();// 要求 Class 对象对应的类有 public 空构造器
        Constructor<?>[] declaredConstructors = ConstructorDemo.class.getDeclaredConstructors();
        declaredConstructors[0].setAccessible(true);
        ConstructorDemo constructorDemo = (ConstructorDemo) declaredConstructors[0].newInstance();
        System.out.println(constructorDemo);
    }
}
