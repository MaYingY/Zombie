package servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.Stu_Book;
import service.StuService;
import service.UserException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 17-5-29.
 */
@WebServlet("/StuServlet")
public class StuServlet extends BaseServlet {
        StuService stuService = new StuService();
        public String rentBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserException {
            Stu_Book stu_book = CommonUtils.toBean(request.getParameterMap(), Stu_Book.class);

            Map<String, String> errors = new HashMap<String, String>();

            String stuName = stu_book.getStuName();
            if(stuName == null || stuName.trim().isEmpty()) {
                errors.put("stuName", "用户名不能为空 ！");
            }

            String bookName = stu_book.getBookName();
            if(bookName == null || bookName.trim().isEmpty()) {
                errors.put("bookName", "图书名称不能为空 ！");
            }

            String days = String.valueOf(stu_book.getDays());
            if(days == null || days.trim().isEmpty()) {
                errors.put("days", "借阅天数不能为空 ！");
            }

            if(errors != null && errors.size() > 0){
                request.setAttribute("errors",errors);
                request.setAttribute("stu_book",stu_book);
                return "rentBook.jsp";
            }

            stuService.rentBook(stu_book);
            request.setAttribute("msgStu","图书借阅成功！");
            return "msgStu.jsp";
        }

    public String returnBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserException {
        Stu_Book stu_book = CommonUtils.toBean(request.getParameterMap(), Stu_Book.class);

        Map<String, String> errors = new HashMap<String, String>();

        String stuName = stu_book.getStuName();
        if(stuName == null || stuName.trim().isEmpty()) {
            errors.put("stuName", "用户名不能为空 ！");
        }

        String bookName = stu_book.getBookName();
        if(bookName == null || bookName.trim().isEmpty()) {
            errors.put("bookName", "图书名称不能为空 ！");
        }

        String days = String.valueOf(stu_book.getDays());
        if(days == null || days.trim().isEmpty()) {
            errors.put("days", "借阅天数不能为空 ！");
        }

        if(errors != null && errors.size() > 0){
            request.setAttribute("errors",errors);
            request.setAttribute("stu_book",stu_book);
            return "returnBook.jsp";
        }

        stuService.returnBook(stu_book);
        request.setAttribute("msgStu","图书归还成功！");
        return "msgStu.jsp";
    }

    public String query(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Stu_Book stu_book = CommonUtils.toBean(request.getParameterMap(), Stu_Book.class);
        request.setAttribute("stu_bookList", stuService.findAll(stu_book));
        return "f:/myList.jsp";
    }

    public String recharge(HttpServletRequest request, HttpServletResponse response) throws SQLException {
            Double money = Double.parseDouble(request.getParameter("money"));
            String name = request.getParameter("name");
            stuService.recharge(name, money);
            request.setAttribute("msgStu", "充值成功 ！");
            return "msgStu.jsp";
    }
}
