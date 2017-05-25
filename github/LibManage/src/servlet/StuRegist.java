package servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.Student;

import service.StuService;
import service.UserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by dell on 17-5-24.
 */
@WebServlet("/StuRegist")
public class StuRegist extends BaseServlet {
    StuService stuService = new StuService();

    public String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, UserException {
        Student student = CommonUtils.toBean(request.getParameterMap(), Student.class);

        //用来装载所有错误信息
        Map<String, String> errors = new HashMap<String, String>();

        //校验用户名
        String stuname = student.getName();
        if(stuname == null || stuname.trim().isEmpty()) {
            errors.put("name","用户名不能为空！");
        } else if(stuname.length() < 3 || stuname.length() > 15) {
            errors.put("name", "用户名长度必须在3~15之间！");
        }

        // 对密码进行校验
        String password = student.getPassword();
        if(password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if(password.length() < 3 || password.length() > 15) {
            errors.put("password", "密码长度必须在3~15之间！");
        }

        if(errors != null && errors.size() > 0){
            request.setAttribute("errors",errors);
            request.setAttribute("student",student);
            return "regist.jsp";
        }

        stuService.addStu(student);
        request.setAttribute("msg","用户添加成功！");
        return "msg.jsp";


    }
}
