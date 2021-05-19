package example.spring5.dao;


import com.sun.rowset.internal.Row;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
/**
 * @author hua
 * @create 2021-04-10 10:25
 */
public class BookDaoImpl implements BookDao{
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql1="insert into t_book values(?,?,?);";
        Object[] args={user.getUserId(),user.getUsername(),user.getUstatus()};
        int update=jdbcTemplate.update(sql1,args);
        System.out.println(update);
    }

    @Override
    public void updateBook(User user) {
       String sql2="update t_book set username=?,ustatus=? where user_id=?;";
        Object[] args={user.getUsername(),user.getUstatus(),user.getUserId()};
        int update=jdbcTemplate.update(sql2,args);
        System.out.println(update);
    }

    @Override
    public void deleteBook(String id) {
        String sql3="delete from t_book where user_id=?;";
        int update=jdbcTemplate.update(sql3,id);
        System.out.println(update);
    }

    @Override
    public int selectCount() {
        String sql4="select count(*) from t_book;";
        int update=jdbcTemplate.queryForObject(sql4,Integer.class);
        return update;
    }
// RowMapper是接口，返回不同类型的数据，使用这个接口的实现类完成数据的封装
    @Override
    public User findBookInfo(String id) {
        String sql5="select * from t_book where user_id=?;";
        User user=jdbcTemplate.queryForObject(sql5,new BeanPropertyRowMapper<User>(User.class),id);

        return user;
    }

    @Override
    public List<User> findAllBook() {
        String sql6="select * from t_book";
        List<User> users=jdbcTemplate.query(sql6,new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void bathcAddBook(List<Object[]> batchArgs) {
        String sql7="insert into t_book values(?,?,?);";
        int[] ints=jdbcTemplate.batchUpdate(sql7,batchArgs);
        System.out.println(Arrays.toString(ints));
    }


    @Override
    public void bathcUpdateBook(List<Object[]> batchArgs) {
        String sql8="update t_book set username=?,ustatus=? where user_id=?;";
        int[] ints=jdbcTemplate.batchUpdate(sql8,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void bathcDeleteBook(List<Object[]> batchArgs) {
        String sql9="delete from t_book where user_id=?;";
        int[] ints=jdbcTemplate.batchUpdate(sql9,batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
