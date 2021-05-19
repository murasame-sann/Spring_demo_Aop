package example.spring5.test;

import example.spring5.aopAnno.User1;
import example.spring5.aopXml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hua
 * @create 2021-04-07 16:44
 */
public class testAop {
    @Test
    public void testAopAnno(){
        ApplicationContext context=new
                ClassPathXmlApplicationContext("bean1.xml");
        User1 user=context.getBean("user", User1.class);
        user.add();
    }
    @Test
    public void testAopXml(){
        ApplicationContext context=new
                ClassPathXmlApplicationContext("bean2.xml");
        Book book=context.getBean("book",Book.class);
        book.buy();
    }
}
