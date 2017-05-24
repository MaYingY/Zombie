package service;

import dao.StuDao;
import domain.Student;

import java.sql.SQLException;

/**
 * Created by dell on 17-5-24.
 */
public class StuService {
    StuDao stuDao = new StuDao();
    public void addStu(Student student) throws SQLException {
        stuDao.addStu(student);
    }
}
