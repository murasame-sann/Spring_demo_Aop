package example.spring5.test;

import entity.User;
import example.spring5.aopXml.Book;
import example.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hua
 * @create 2021-04-11 13:51
 */
public class testJdbcTemplate {
    @Test
    public void testjdbcTemplate(){
        ApplicationContext context=new
                ClassPathXmlApplicationContext("bean3.xml");
        BookService bookService=context.getBean("bookService",BookService.class);
//        User user=new User();
//        user.setUserId("1");
//        user.setUsername("asd");
//        user.setUstatus("abc123");
//        int count=bookService.findCount();
//        System.out.println(count);
//        User user=bookService.findOne("1");
//        System.out.println(user);
//        List<User> user=bookService.findAll();
//        System.out.println(user);
//        List<Object[]> batchArgs=new ArrayList<>();
//        Object[] o1={"3","java","a"};
//        Object[] o2={"4","c++","b"};
//        Object[] o3={"5","python","c"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        // 调用批量添加方法
//        bookService.batchAdd(batchArgs);
        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={"3"};
        Object[] o2={"4"};
        Object[] o3={"5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        // 调用批量添加方法
        bookService.batchDelete(batchArgs);

    }
}
