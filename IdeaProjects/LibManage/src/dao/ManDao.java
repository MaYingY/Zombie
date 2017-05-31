package dao;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Manager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by dell on 17-5-26.
 */
public class ManDao {
    QueryRunner queryRunner = new TxQueryRunner();
    public Manager manLogin(String username) throws SQLException {
        String sql = "select * from manager where username = ?";
//        System.out.println(username);
        return queryRunner.query(sql, new BeanHandler<Manager>(Manager.class), username);
    }
}
