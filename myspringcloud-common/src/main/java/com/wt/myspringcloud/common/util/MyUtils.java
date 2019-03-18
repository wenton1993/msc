package com.wt.myspringcloud.common.util;

import com.wt.myspringcloud.common.core.BaseRemoteReq;
import com.wt.myspringcloud.common.core.JsonResult;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MyUtils {

    public static Map<String, String> sign(BaseRemoteReq remoteReq) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, String> map = BeanUtils.describe(remoteReq);
        return map;
    }

}
