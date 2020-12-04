package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 文通
 * @since 2020/12/4
 */
public class RegexDemo {

    public static void main(String[] args) {
        System.out.println("End");

        // 正则表达式
        Matcher m = Pattern.compile("(^|_)\\w").matcher("gdzh_zxzbeccl_group");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group().replaceAll("_", "").toUpperCase());
        }
        m.appendTail(sb);

        System.out.println("End");
    }

}
