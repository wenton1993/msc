package proxy.cglib;

import proxy.statical.TestUserImpl;
import proxy.statical.TestUserService;

/**
 * @author 文通
 * @since 2019/9/12
 */
public class Runner {

    public static void main(String[] args) {
        TestInterceptor proxy = new TestInterceptor();
        // 通过生成子类的方式创建代理类
        TestUserService proxyImp = (TestUserService) proxy.getProxy(TestUserImpl.class);
        proxyImp.query();
    }
}
