package example.spring5;

/**
 * @author hua
 * @create 2021-04-05 10:19
 */
public class UserDaoImpl implements UserDao{

    @Override
    public int add(int a, int b) {
        System.out.println("add执行了。。。");
        return a+b;
    }

    @Override
    public String update(String id) {
        System.out.println("update执行了。。。");
        return id;
    }
}
