package Servlet;

import cn.itcast.servlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by dell on 17-6-17.
 */
public class ZoneServlet extends BaseServlet {
    public void deGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if("getProvince".equals(action)) {
            this.getProvince(request, response);
        } else if("getCity".equals(action)) {
            this.getCity(request, response);
        }
    }

    private void getCity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("GBK");
        String result = "";
        CityMap cityMap = new CityMap();
        Map<String, String[]> map = cityMap.model;
        Set<String> set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            result = result + it.next()+",";
        }
        result = result.substring(0, result.length() - 1);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    private void getProvince(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("GBK");
        String result = "";
            String selProvince = request.getParameter("parProvince");
            selProvince = new String(selProvince.getBytes("ISO-8859-1"), "GBK");
            CityMap cityMap = new CityMap();
            Map<String, String[]> map = cityMap.model;
            String[] arrCity = map.get(selProvince);
            for(int i = 0; i < arrCity.length; i ++) {
                result = result + arrCity[i] + ",";
            }

            result = result.substring(0, result.length() - 1);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print(result);
            out.flush();
            out.close();
    }

}
