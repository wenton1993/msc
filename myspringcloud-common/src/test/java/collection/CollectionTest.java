package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 文通
 * @since 2019/5/28
 */
public class CollectionTest {

    public enum Color {

        RED("红色"),
        YELLO("黄色"),
        WHITE("白色"),

        ;

        private String name;

        Color(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

    }

}
