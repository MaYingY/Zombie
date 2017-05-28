package web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.User;
import service.UserException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzp on 2017/3/6.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends BaseServlet {
    UserService userService = new UserService();
    public String addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        User user = CommonUtils.toBean(request.getParameterMap(),User.class);
        //System.out.println(user);
        // 用来装载所有错误信息
        Map<String,String> errors = new HashMap<String,String>();

        // 对用户名进行校验
        String username = user.getUsername();//获取表单的username
        if(username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空！");
        } else if(username.length() < 3 || username.length() > 15) {
            errors.put("username", "用户名长度必须在3~15之间！");
        }

        // 对密码进行校验
        String password = user.getPassword();
        if(password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if(password.length() < 3 || password.length() > 15) {
            errors.put("password", "密码长度必须在3~15之间！");
        }

        if(errors != null && errors.size() > 0){
            request.setAttribute("errors",errors);
            request.setAttribute("user",user);
            return "register.jsp";
        }

        try {
            userService.add(user);
            request.setAttribute("msg","用户添加成功！");
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
        }
        return "msg.jsp";
    }
}
