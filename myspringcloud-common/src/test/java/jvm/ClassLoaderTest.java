package jvm;

import org.aspectj.apache.bcel.util.DefaultClassLoaderReference;

/**
 * @author 文通
 * @since 2019/6/25
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };

        Object aClass = myClassLoader.loadClass("java.lang.Test");
        System.out.println(aClass.getClass());
        System.out.println(aClass.getClass().getClassLoader());
        System.out.println(aClass instanceof jvm.ClassLoaderTest);

        /*ClassLoaderTest classLoaderTest = new ClassLoaderTest();

        ClassLoader classLoader = classLoaderTest.getClass().getClassLoader();
        Object aClass2 = classLoader.loadClass("jvm.ClassLoaderTest");
        System.out.println(aClass2.getClass());
        System.out.println(aClass2.getClass().getClassLoader());
        System.out.println(aClass2 instanceof ClassLoaderTest);


        System.out.println(classLoaderTest.getClass());
        System.out.println(classLoaderTest.getClass().getClassLoader());
        System.out.println(classLoaderTest instanceof ClassLoaderTest);*/
    }
}
