package web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.User;
import service.UserException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by zzp on 2017/3/6.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends BaseServlet {
    UserService userService = new UserService();
    public String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = CommonUtils.toBean(request.getParameterMap(),User.class);
        try {
            User user1 = userService.login(user);
            request.getSession().setAttribute("sessionUser",user1);
            request.setAttribute("msg","登录成功！");
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
        }
        return "msg.jsp";
    }
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("sessionUser");
        return null;
    }
}
