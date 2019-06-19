package com.wt.myspringcloud.user.feign;

import com.wt.myspringcloud.common.api.ListenerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("listener")
public interface ListenerFeign extends ListenerApi {
}
