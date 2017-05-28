package service;

import dao.StudentDao;
import domain.PageBean;
import domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zzp on 2017/2/20.
 */
public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public void add(Student stu) throws SQLException {
        studentDao.add(stu);
    }


    public Student load(String id) throws SQLException {
        return studentDao.load(id);
    }

    public void edit(Student stu) throws SQLException {
        studentDao.edit(stu);
    }

    public void delete(String id) throws SQLException {
        studentDao.delete(id);
    }

//    public PageBean<Student> findAll(int pageCode, int pageSize) throws SQLException {
//        return studentDao.findAll(pageCode, pageSize);
//    }
    public List<Student> findAll() throws SQLException {
        return studentDao.findAll();
    }

    public PageBean<Student> query(Student criteria, int pageCode, int pageSize) throws SQLException {
        return studentDao.query(criteria,pageCode,pageSize);
    }
}
