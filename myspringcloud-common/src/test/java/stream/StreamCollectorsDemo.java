package stream;

import com.wt.myspringcloud.common.enumeration.field.PublishStatus;
import com.wt.myspringcloud.common.pojo.entity.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 使用收集器的例子
 *
 * @author 文通
 * @since 2020/5/24
 */
public class StreamCollectorsDemo {

    public static void main(String[] args) {
        // 创建产品List，用于测试
        List<Product> productList = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            Product product = new Product();
            product.setPrice(100 * 100);
            product.setPublishStatus(PublishStatus.ON);
            product.setStock(1000);
            product.setSale(0);
            product.setCreateDateTime(LocalDateTime.now());
            product.setId(Integer.valueOf(i).toString());
            product.setName("榴莲" + i);
            product.setProductCategoryId(1 + i % 5);
            productList.add(product);
        }
        // 功能：分组，是分类1和不是分类1的商品
        Map<Boolean, List<Product>> productMap = productList.stream()
                .collect(Collectors.partitioningBy(p -> p.getProductCategoryId().equals(1)));

        // 功能：分组，根据商品类别分成多组
        Map<Integer, List<Product>> productMap2 = productList.stream()
                .collect(Collectors.groupingBy(Product::getProductCategoryId));

        // 功能：拼接字符串
        String stringResult = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(",", "[", "]"));

        // 结束，用于断电测试
        System.out.println("End");
    }
}
