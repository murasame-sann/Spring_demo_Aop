package example.spring5.service;

import entity.User;
import example.spring5.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * @author hua
 * @create 2021-04-10 10:25
 */
public class BookService {
    //注入Dao
    @Autowired
    public BookDao bookDao;
    public void addBook(User user){
        bookDao.add(user);
    }
    public void updateBook(User user){
        bookDao.updateBook(user);
    }
    public void deleteBook(String id){
        bookDao.deleteBook(id);
    }
    public int findCount(){
        return bookDao.selectCount();
    }
    public User findOne(String id){
        return bookDao.findBookInfo(id);
    }
    public List<User> findAll(){
        return bookDao.findAllBook();
    }
    public void batchAdd(List<Object[]> batchArgs){
        bookDao.bathcAddBook(batchArgs);
    }
    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.bathcUpdateBook(batchArgs);
    }
    public void batchDelete(List<Object[]> batchArgs){
        bookDao.bathcDeleteBook(batchArgs);
    }
}
