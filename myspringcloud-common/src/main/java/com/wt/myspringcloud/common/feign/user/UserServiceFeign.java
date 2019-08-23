package com.wt.myspringcloud.common.feign.user;

import com.wt.myspringcloud.common.api.user.UserServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 文通
 * @since 2019/8/22
 */
@FeignClient("user")
public interface UserServiceFeign extends UserServiceApi {
}
