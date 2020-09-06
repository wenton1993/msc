package com.wt.myspringcloud.demo.json;

import com.wt.myspringcloud.common.constant.RandomName;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.pojo.entity.Demo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author 文通
 * @since 2020/9/6
 */
@Slf4j
public class JsonTest extends BaseTest {

    @Test
    public void testJson() {
        Demo demo = new Demo();
        demo.setId(null);
        demo.setName(RandomName.getRandomName().toString());
        demo.setAge(RandomUtils.nextInt(18, 30));
        demo.setPrice(Money.of(CurrencyUnit.of("CNY"), RandomUtils.nextLong(10_00, 100_00)));
        demo.setCreateDatetime(LocalDateTime.now().minusDays(RandomUtils.nextInt(0, 7)));
        demo.setDeleteStatus(0);
        demo.setVersion(0L);
        log.info(demo.toString());
    }

}
