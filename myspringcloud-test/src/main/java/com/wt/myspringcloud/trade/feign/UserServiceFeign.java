package com.wt.myspringcloud.trade.feign;

import com.wt.myspringcloud.common.api.user.UserServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 文通
 * @since 2020/5/21
 */
@FeignClient(value = "user")
public interface UserServiceFeign extends UserServiceApi {
}
