package servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.Manager;
import service.ManService;
import service.UserException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by dell on 17-5-26.
 */
@WebServlet("/ManServlet")
public class ManServlet extends BaseServlet {
    ManService manService = new ManService();
    public String manLogin(HttpServletRequest request, HttpServletResponse response) {
        Manager manager = CommonUtils.toBean(request.getParameterMap(), Manager.class);
        try {
            Manager manager1 = manService.manLogin(manager);
            request.getSession().setAttribute("sessionUser", manager1);
            request.setAttribute("msgMan", "登录成功！");
        } catch (UserException e) {
            request.setAttribute("msgMan",e.getMessage());
            return "manLogin.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "msgMan.jsp";

    }
}
