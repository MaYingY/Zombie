package servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.Student;
import service.StuService;
import service.UserException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by dell on 17-5-26.
 */
@WebServlet("/StuLogin")
public class StuLogin extends BaseServlet{
    StuService stuService = new StuService();

    public String stuLogin(HttpServletRequest request, HttpServletResponse response) {

        Student student = CommonUtils.toBean(request.getParameterMap(),Student.class);
        try {
            Student student1 = stuService.stuLogin(student);
            request.getSession().setAttribute("sessionUser",student1);
            request.setAttribute("msgStu","登录成功！");
        } catch (UserException e) {
            request.setAttribute("msgStu",e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "msgStu.jsp";
    }

}
