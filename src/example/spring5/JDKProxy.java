package example.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author hua
 * @create 2021-04-05 10:20  动态代理
 */
public class JDKProxy {
    public static void main(String[] args) {
        //创建接口实现类的代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao=new UserDaoImpl();
        UserDao dao=(UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int c=dao.add(1,2);
        System.out.println(c);
    }
}
//创建代理对象代码
class UserDaoProxy implements InvocationHandler{
    //传递UserDaoImpl的对象，1.通过有参构造传递
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前执行。。。"+method.getName()+" :传递的参数。。。"+ Arrays.toString(args));
        Object res=method.invoke(obj,args);
        System.out.println("方法之后执行。。。"+obj);
        return res;
    }
}