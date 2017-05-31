package service;

import dao.BookDao;
import domain.Book;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dell on 17-5-26.
 */
public class BookService {
    BookDao bookDao = new BookDao();
    public void addBook(Book book) throws SQLException {
        bookDao.addBook(book);
    }

    /*public PageBean<Book> query(Book book, int pageCode, int pageSize) throws SQLException {
        return bookDao.query(book, pageCode, pageSize);
    }*/

    public void preEdit(Book book) throws SQLException {
        bookDao.preEdit(book);
    }

    public void delete(String id) throws SQLException {
        bookDao.delete(id);
    }

    public List<Book> findAll(Book book) throws SQLException {
        return bookDao.findAll(book);
    }
}
