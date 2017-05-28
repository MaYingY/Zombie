package dao;

import cn.itcast.jdbc.TxQueryRunner;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by zzp on 2017/3/7.
 */
public class UserDao {
    private QueryRunner queryRunner = new TxQueryRunner();
    public void add(User user) throws SQLException {
        String sql = "insert into user values(?,?,?)";
        Object[] params = {user.getId(),user.getUsername(),user.getPassword()};
        queryRunner.update(sql,params);
    }

    public User load(String username) throws SQLException {
        String sql = "select * from user where username=?";
        return queryRunner.query(sql,new BeanHandler<User>(User.class),username);
    }
}
