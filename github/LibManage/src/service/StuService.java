package service;

import dao.StuDao;
import domain.Stu_Book;
import domain.Book;
import domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dell on 17-5-24.
 */
public class StuService {
    StuDao stuDao = new StuDao();
    public void addStu(Student student) throws SQLException {
        stuDao.addStu(student);
    }

    public Student stuLogin(Student student) throws UserException, SQLException {
        Student student1 = stuDao.login(student.getName());
        if(student1 == null) throw new UserException("用户名不存在！");
        else if(!student1.getPassword().equals(student.getPassword()))
            throw new UserException("密码不正确！");
        return student1;
    }

    public void rentBook(Stu_Book stu_book) throws SQLException, UserException {
        Double money = stuDao.update(stu_book.getStuName(), stu_book.getBookName(),
                stu_book.getDays());
        if(money < 0) throw new UserException("帐户余额不足 ！");
        Book book = stuDao.bookMoney(stu_book.getBookName());
        if(book.getAgoCount() - 1 < 0) throw new UserException("图书库存不足 ！");
        stuDao.rentBook(stu_book);
    }

    public void returnBook(Stu_Book stu_book) throws SQLException {
        stuDao.backUpdate(stu_book.getStuName(), stu_book.getBookName(),
                stu_book.getDays());
        stuDao.returnBook(stu_book);
    }

    public List<Stu_Book> findAll(Stu_Book stu_book) throws SQLException {
        return stuDao.findAll(stu_book);
    }

    public void recharge(String name, Double money) throws SQLException {
        stuDao.recharge(name, money);
    }
}
