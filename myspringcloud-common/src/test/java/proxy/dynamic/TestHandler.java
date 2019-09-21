package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 文通
 * @since 2019/9/12
 */
public class TestHandler implements InvocationHandler {

    private Object target;

    public TestHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("被代理对象的类型：" + target.getClass().getName());
        System.out.println("被代理的方法：" + method.getName());
        if (method.getName().equals("print")) {
            System.out.println("before print");
            result = method.invoke(target, args);
            System.out.println("after print");
        } else {
            result = method.invoke(target, args);
            System.out.println("record");
        }
        return result;
    }

    /**
     * 创建代理并返回
     * @return 代理
     */
    public Object getTarget() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
