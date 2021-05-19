package example.spring5.aopAnno;

import org.springframework.stereotype.Component;

@Component
//被增强类
/**
 * @author hua
 * @create 2021-04-07 15:57
 */
public class User1 {
    public void add(){
        System.out.println("add......");
    }
}
