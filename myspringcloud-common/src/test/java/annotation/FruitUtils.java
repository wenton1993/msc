package annotation;

import java.lang.reflect.Field;

/**
 * @author 文通
 * @since 2019/6/25
 */
public class FruitUtils {

    public static void showFruitInfo(Class<?> clz) {
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider annotation = field.getAnnotation(FruitProvider.class);
                System.out.println("id: " + annotation.id() + ", "
                        + "name: " + annotation.name() + ", "
                        + "address: " + annotation.address());
            }
        }
    }

    public static void main(String[] args) {
        FruitUtils.showFruitInfo(Apple.class);
    }
}
