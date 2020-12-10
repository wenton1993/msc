package com.wt.myspringcloud.stream.channel;

/**
 * 这个接口用于将 OrderSource 和 OrderSink 通过
 * @author 文通
 * @since 2019/8/25
 */
public interface OrderProcessor extends OrderSource, OrderSink {
}
