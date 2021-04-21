package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * <p>
 * 比较静态代理
 * 1.不需要实现任何业务接口
 */
public class TestUserHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object target;

    /**
     * 根据被代理对象创建代理对象
     *
     * @param target 被代理对象
     */
    public TestUserHandler(Object target) {
        this.target = target;
    }

    /**
     * 代理方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    /**
     * 在被代理方法之前执行
     */
    private void before() {
        System.out.println("代理 before");
    }

    /**
     * 在被代理方法之后执行
     */
    public void after() {
        System.out.println("代理 after");
    }

    /**
     * 创建代理并返回
     *
     * @return 代理
     */
    public Object getTarget() {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

}
