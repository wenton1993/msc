package com.wt.myspringcloud.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author 文通
 * @since 2020/9/6
 */
@JsonComponent
public class JsonConfig {

    public static class MoneySerializer extends JsonSerializer<Money> {

        @Override
        public void serialize(Money money, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(money.getAmount());
        }

    }

    public static class MoneyDeserializer extends JsonDeserializer<Money> {

        @Override
        public Money deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return Money.of(CurrencyUnit.of("CNY"), p.getDecimalValue());// 数据库存浮点数
        }

    }

}
