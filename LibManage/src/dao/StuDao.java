package dao;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Student;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * Created by dell on 17-5-24.
 */
public class StuDao {
    QueryRunner qr = new TxQueryRunner();
    public void addStu(Student student) throws SQLException {
        String sql = "insert into studennt values(?,?)";
        Object[] params = {student.getName(), student.getPassword()};
        qr.update(sql, params);
    }
}
