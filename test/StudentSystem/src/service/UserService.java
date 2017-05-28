package service;

import dao.UserDao;
import domain.User;

import java.sql.SQLException;

/**
 * Created by zzp on 2017/3/7.
 */
public class UserService {
    UserDao userDao = new UserDao();

    public void add(User user) throws SQLException, UserException {
        User user1 = userDao.load(user.getUsername());
        if(user1 != null){
            throw new UserException("该用户名："+user.getUsername()+",已经被注册过了！");
        }
        userDao.add(user);
    }

    public User login(User user) throws SQLException, UserException {
        User user1 = userDao.load(user.getUsername());
        if(user1 == null) throw new UserException("用户名不存在！");
        else if(!user1.getPassword().equals(user.getPassword()))
            throw new UserException("密码不正确！");
        return user1;
    }
}
