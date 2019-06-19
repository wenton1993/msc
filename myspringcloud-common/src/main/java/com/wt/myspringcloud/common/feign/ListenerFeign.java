package com.wt.myspringcloud.common.feign;

import com.wt.myspringcloud.common.api.ListenerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("myspringcloud-listener")
public interface ListenerFeign extends ListenerApi {
}
