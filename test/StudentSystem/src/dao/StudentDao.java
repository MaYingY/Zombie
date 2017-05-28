package dao;

import cn.itcast.jdbc.TxQueryRunner;
import domain.PageBean;
import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzp on 2017/2/20.
 */
public class StudentDao {
    private QueryRunner qr = new TxQueryRunner();
    public void add(Student stu) throws SQLException {
        String sql = "insert into student values(?,?,?,?,?)";
        Object[] params = { stu.getId(), stu.getName(),
        stu.getBirthday(), stu.getPhone(), stu.getaddress()};
        qr.update(sql, params);
    }

    public Student load(String id) throws SQLException {
        String sql = "select * from student where id = ?";
        return qr.query(sql, new BeanHandler<Student>(Student.class), id);
    }

    public void edit(Student stu) throws SQLException {
        String sql = "update student set name=?, birthday=?, phone=?, address=? where id=?";
        Object[] params = {stu.getName(), stu.getBirthday(), stu.getPhone(), stu.getaddress(), stu.getId()};
        qr.update(sql,params);
    }

    public void delete(String id) throws SQLException {
        String sql = "delete from student where id=?";
        qr.update(sql,id);
    }

    public List<Student> findAll() throws SQLException {
        String sql = "select * from student";
        return qr.query(sql, new BeanListHandler<Student>(Student.class));
    }

//    public PageBean<Student> findAll(int pageCode, int pageSize) throws SQLException {
//
//        PageBean<Student> pageBean = new PageBean<Student>();
//        pageBean.setPageCode(pageCode);
//        pageBean.setPageSize(pageSize);
//
//        String sql = "select count(*) from student";
//        Number  number = (Number)qr.query(sql, new ScalarHandler());
//        int totalRecode = number.intValue();
//        pageBean.setTotalRecode(totalRecode);
//
//        sql = "select * from student order by name limit ?,?";
//        List<Student> students = qr.query(sql,new BeanListHandler<Student>(Student.class),(pageCode-1)*pageSize,pageSize);
//        pageBean.setBeanList(students);
//        return pageBean;
//    }

    public PageBean<Student> query(Student criteria, int pageCode, int pageSize) throws SQLException {
        PageBean<Student> pageBean = new PageBean<Student>();
        pageBean.setPageSize(pageSize);
        pageBean.setPageCode(pageCode);

        StringBuilder sql = new StringBuilder("select count(*) from student");
        StringBuilder whereSql = new StringBuilder(" where 1=1");

        ArrayList<Object> params = new ArrayList<Object>();

        if(criteria.getName()!=null && !criteria.getName().trim().isEmpty()){
            whereSql.append(" and name like ?");
            params.add("%" + criteria.getName() + "%");
        }
        if(criteria.getBirthday() != null){
            whereSql.append(" and birthday=?");
            params.add(criteria.getBirthday());
        }
        if(criteria.getPhone()!=0){
            whereSql.append(" and phone=?");
            params.add(criteria.getPhone());
        }
        if(criteria.getaddress()!=null){
            whereSql.append(" and address=?");
            params.add(criteria.getaddress());
        }
        Number number = (Number)qr.query(sql.append(whereSql).toString(),new ScalarHandler(),params.toArray());
        int totalRecode = number.intValue();
        pageBean.setTotalRecode(totalRecode);

        StringBuilder listSql = new StringBuilder("select * from student");
        StringBuilder limitSql = new StringBuilder(" limit ?,?");
        params.add((pageCode-1)*pageSize);
        params.add(pageSize);
        List<Student> beanList =  qr.query(listSql.append(whereSql).append(limitSql).toString(),
                new BeanListHandler<Student>(Student.class),params.toArray());
        pageBean.setBeanList(beanList);
        return pageBean;
    }
}
