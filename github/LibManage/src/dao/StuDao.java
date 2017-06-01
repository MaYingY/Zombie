package dao;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Book;
import domain.Stu_Book;
import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dell on 17-5-24.
 */
public class StuDao {
    QueryRunner qr = new TxQueryRunner();
    public void addStu(Student student) throws SQLException {
        String sql = "insert into student values(NULL,?,?,NULL,50)";
//        System.out.println(student.getName()+student.getPassword());
        Object[] params = {student.getName(), student.getPassword()};
        qr.update(sql, params);
    }

    public Student login(String name) throws SQLException {
        String sql = "select * from student where name = ?";
//        System.out.println(name);
        return qr.query(sql, new BeanHandler<Student>(Student.class), name);
    }

    public void rentBook(Stu_Book stu_book) throws SQLException {
        String sql = "insert into stu_book values(?,?,?)";
        Object[] params = {stu_book.getStuName(), stu_book.getBookName(), stu_book.getDays()};
        qr.update(sql, params);
    }

    public Double update(String stuName, String bookName, int days) throws SQLException {
        String sql = "select * from student where name=?";
        Student student = qr.query(sql, new BeanHandler<Student>(Student.class), stuName);
        Book bookMoney = bookMoney(bookName);
        String sql2 = "update student set bookcount=?, money=? where name=?";
        Object[] params = {student.getBookcount()+1, student.getMoney()-bookMoney.getDayMoney()*days, stuName};
        if(student.getMoney()-bookMoney.getDayMoney()*days >= 0) {
            qr.update(sql2, params);
        }
        return student.getMoney()-bookMoney.getDayMoney()*days;
    }
    public Book bookMoney(String name) throws SQLException {
        String sql = "select * from book where name = ?";
        Book book = qr.query(sql, new BeanHandler<Book>(Book.class), name);
        String sql1 = "update book set agoCount=?, flag=? where name =?";
        Object[] params = {book.getAgoCount()-1, 1, name};
        if(book.getAgoCount() - 1 >= 0) {
            qr.update(sql1, params);
        }
        return book;
    }

    public void returnBook(Stu_Book stu_book) throws SQLException {
        String sql = "delete from stu_book where stuName=?";
        qr.update(sql, stu_book.getStuName());
    }

    public void backUpdate(String stuName, String bookName, int days) throws SQLException {
        String sql = "select * from student where name=?";
        Student student = qr.query(sql, new BeanHandler<Student>(Student.class), stuName);
        String sql2 = "update student set bookcount=? where name=?";
        Object[] params = {student.getBookcount()-1, stuName};
        qr.update(sql2, params);
        backBook(bookName);
    }

    public void backBook(String name) throws SQLException {
        String sql = "select * from book where name = ?";
        Book book = qr.query(sql, new BeanHandler<Book>(Book.class), name);
        String sql1 = "update book set agoCount=?, flag=? where name =?";
        Object[] params = {book.getAgoCount()+1, 0, name};
        qr.update(sql1, params);
    }

    public List<Stu_Book> findAll(Stu_Book stu_book) throws SQLException {
        String sql = "select * from stu_book where stuName=?";
        return qr.query(sql, new BeanListHandler<Stu_Book>(Stu_Book.class), stu_book.getStuName());
    }

    public void recharge(String name, Double money) throws SQLException {
        String sql = "update student set money=? where name=?";
        Double money1 = getStuMoney(name);
        Object[] params = {money+money1, name};
        qr.update(sql, params);
    }
    public Double getStuMoney(String name) throws SQLException {
        String sql = "select * from student where name=?";
        Student student = qr.query(sql, new BeanHandler<Student>(Student.class), name);
        return student.getMoney();
    }
}
