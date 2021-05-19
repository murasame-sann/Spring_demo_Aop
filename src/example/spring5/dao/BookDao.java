package example.spring5.dao;

import entity.User;

import java.util.List;

/**
 * @author hua
 * @create 2021-04-10 10:26
 */
public interface BookDao {
    public void add(User user);
    public void updateBook(User user);
    public void deleteBook(String id);

    int selectCount();

    User findBookInfo(String id);

    List<User> findAllBook();

    void bathcAddBook(List<Object[]> batchArgs);

    void bathcUpdateBook(List<Object[]> batchArgs);

    void bathcDeleteBook(List<Object[]> batchArgs);
}
