package service;

import dao.ManDao;
import domain.Manager;

import java.sql.SQLException;

/**
 * Created by dell on 17-5-26.
 */
public class ManService {
    ManDao manDao = new ManDao();
    public Manager manLogin(Manager manager) throws UserException, SQLException {
        Manager manager1 = manDao.manLogin(manager.getUsername());
        if(manager1 == null) throw new UserException("用户名不存在 ！");
        else if( ! manager1.getPassword().equals(manager.getPassword()))
            throw new UserException("密码错误 ！");
        return manager1;
    }
}
