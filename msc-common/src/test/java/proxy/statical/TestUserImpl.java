package proxy.statical;

/**
 * 被代理接口的实现类
 */
public class TestUserImpl implements TestUserService {

    @Override
    public void query() {
        System.out.println("查询用户信息");
    }

}