package com.wt.myspringcloud.common.feign.listener;

import com.wt.myspringcloud.common.api.listener.ListenerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("stream")
public interface ListenerFeign extends ListenerApi {
}
