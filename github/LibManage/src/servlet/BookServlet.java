package servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import domain.Book;
import service.BookService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by dell on 17-5-26.
 */
@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
    BookService bookService = new BookService();

    public String addBook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);

        Map<String, String> errors = new HashMap<String, String>();

        String id = String.valueOf(book.getId());
        if(id == null || id.trim().isEmpty()) {
            errors.put("id","图书编号不能为空 ！");
        }

        String name = book.getName();
        if(name == null || name.trim().isEmpty()) {
            errors.put("name", "图书名称不能为空 ！");
        }

        String type = book.getType();
        if(type == null || type.trim().isEmpty()) {
            errors.put("type", "图书型号不能为空 ！");
        }

        String price = String.valueOf(book.getPrice());
        if(price == null || price.trim().isEmpty()) {
            errors.put("price", "图书价格不能为空 ！");
        }

        String pbHouse = book.getPublishingHouse();
        if(pbHouse == null || pbHouse.trim().isEmpty()) {
            errors.put("publishingHouse", "出版地址不能为空 ！");
        }

        String author = book.getAuthor();
        if(author == null || author.trim().isEmpty()) {
            errors.put("author", "图书作者不能为空 ！");
        }

        String bookCount = String.valueOf(book.getBookCount());
        if(bookCount == null || bookCount.trim().isEmpty()) {
            errors.put("bookCount", "图书数量不能为空 ！");
        }

        String dayMoney = String.valueOf(book.getDayMoney());
        if(dayMoney == null || dayMoney.trim().isEmpty()) {
            errors.put("dayMoney", "每日租金不能为空 ！");
        }

        String agoCount = String.valueOf(book.getAgoCount());
        if(agoCount == null || agoCount.trim().isEmpty()) {
            errors.put("agoCount", "当前库存不能为空 ！");
        }

        if(errors != null && errors.size() > 0){
            request.setAttribute("errors",errors);
            request.setAttribute("book",book);
            return "addBook.jsp";
        }

        bookService.addBook(book);
        request.setAttribute("msg","图书添加成功！");
        return "msg.jsp";
    }

    public String preEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
//        System.out.println(book);
        bookService.preEdit(book);
        request.setAttribute("msgMan","图书信息修改成功！");
        return "msgMan.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        bookService.delete(id);
        request.setAttribute("msgMan","图书信息删除成功！");
        return "msgMan.jsp";
    }
    public String query(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
        request.setAttribute("bookList", bookService.findAll(book));
        return "f:/list.jsp";
    }
    /*public String query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Book book = CommonUtils.toBean(request.getParameterMap(),Book.class);
        int pageCode = getPageCode(request);
        int pageSize = 10;
        PageBean<Book> pageBean = bookService.query(book,pageCode,pageSize);
        pageBean.setUrl(getUrl(request));
        request.setAttribute("bookList",pageBean);
        return "list.jsp";
    }

    private int getPageCode(HttpServletRequest request) {
        String value = request.getParameter("pageCode");
        if(value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
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
    }*/

}
