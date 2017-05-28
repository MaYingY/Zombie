package web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import domain.PageBean;
import domain.Student;
import service.StudentService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;


/**
 * Created by zzp on 2017/2/20.
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {
    private StudentService studentService = new StudentService();

    public String add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student stu = CommonUtils.toBean(request.getParameterMap(), Student.class);
        //System.out.println(stu);
        try {
            studentService.add(stu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg","学生信息添加成功！");
        return "msg.jsp";
    }

//    public String findAll(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        int pageCode = getPageCode(request);
//        int pageSize = 10;
//        PageBean<Student> studentPageBean = studentService.findAll(pageCode, pageSize);
//        studentPageBean.setUrl(getUrl(request));
//        request.setAttribute("stuList",studentPageBean);
//        return "main.jsp";
//    }
    public String findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        request.setAttribute("stuList", studentService.findAll());
        return "main.jsp";
    }

    private int getPageCode(HttpServletRequest request){
        String value = request.getParameter("pageCode");
        if(value == null || value.trim().isEmpty()){
            return 1;
        }
        return Integer.parseInt(value);
    }

    public String preEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            String id = request.getParameter("id");
            request.setAttribute("stu1",studentService.load(id));
            return "edit.jsp";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Student stu = CommonUtils.toBean(request.getParameterMap(),Student.class);
        System.out.println(stu);
        studentService.edit(stu);
        request.setAttribute("msg","学生信息修改成功！");
        return "msg.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        studentService.delete(id);
        request.setAttribute("msg","学生信息删除成功！");
        return "msg.jsp";
    }

    public String query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Student criteria = CommonUtils.toBean(request.getParameterMap(),Student.class);
        int pageCode = getPageCode(request);
        int pageSize = 10;
        PageBean<Student> pageBean = studentService.query(criteria,pageCode,pageSize);
        pageBean.setUrl(getUrl(request));
        request.setAttribute("stuList",pageBean);
        return "list.jsp";
    }

    private String getUrl(HttpServletRequest request){
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();

        if(queryString.contains("&pageCode=")){
            int index = queryString.lastIndexOf("&pageCode=");
            queryString = queryString.substring(0,index);
        }

        return contextPath + servletPath + "?" + queryString;
    }
}
