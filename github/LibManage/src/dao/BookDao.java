package dao;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dell on 17-5-26.
 */
public class BookDao {
    QueryRunner queryRunner = new TxQueryRunner();
    public void addBook(Book book) throws SQLException {
        String sql = "insert into book values(?,?,?,?,?,?,?,?,0,?)";
        Object[] params = {book.getId(), book.getName(), book.getType()
        , book.getPrice(), book.getPublishingHouse(), book.getAuthor(),
        book.getBookCount(), book.getDayMoney(), book.getAgoCount()};
        queryRunner.update(sql, params);
    }

    public void preEdit(Book book) throws SQLException {
        String sql = "update book set id=?, type=?,price=?,publishingHouse=?,author=?,bookCount=?,dayMoney=?,agoCount=? where name = ?";
        Object[] params = {book.getId(), book.getType()
                , book.getPrice(), book.getPublishingHouse(), book.getAuthor(),
                book.getBookCount(), book.getDayMoney(), book.getAgoCount(), book.getName()};
        queryRunner.update(sql, params);


    }

    public void delete(String id) throws SQLException {
        String sql = "delete from book where id = ?";
        queryRunner.update(sql, id);
    }

    public List<Book> findAll(Book book) throws SQLException {
        String sql = "select * from book where name=?";
        return queryRunner.query(sql, new BeanListHandler<Book>(Book.class), book.getName());
    }

    /*public PageBean<Book> query(Book book, int pageCode, int pageSize) throws SQLException {
        PageBean<Book> pageBean = new PageBean<Book>();
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        StringBuilder sql = new StringBuilder("select count(*) from book");
        StringBuilder whereSql = new StringBuilder(" where 1=1");

        ArrayList<Object> params = new ArrayList<Object>();

        int id = book.getId();
        if(id != 0) {
            whereSql.append(" and id=?");
            params.add(id);
        }
        System.out.println(id);

        String name = book.getName();
        if(name != null && !name.trim().isEmpty()) {
            whereSql.append(" and name=?");
            params.add(name);
        }

        String type = book.getType();
        if(type != null && !type.trim().isEmpty()) {
            whereSql.append(" and type=?");
            params.add(type);
        }

        String price = String.valueOf(book.getPrice());
        if(price != null && !price.trim().isEmpty()) {
            whereSql.append(" and price=?");
            params.add(price);
        }

        String publishingHouse = book.getPublishingHouse();
        if(publishingHouse != null && !publishingHouse.trim().isEmpty()) {
            whereSql.append(" and publishingHouse=?");
            params.add(publishingHouse);
        }


        String author = book.getAuthor();
        if(author != null && !author.trim().isEmpty()) {
            whereSql.append(" and author=?");
            params.add(author);
        }

        String dayMoney = String.valueOf(book.getDayMoney());
        if(dayMoney != null && !dayMoney.trim().isEmpty()) {
            whereSql.append(" and dayMoney=?");
            params.add(dayMoney);
        }
        System.out.println(sql.append(whereSql).toString());
        Number num = (Number) queryRunner.query(sql.append(whereSql).toString(),
                new ScalarHandler(), params.toArray());
        int totalRecode = num.intValue();
        System.out.println(totalRecode);
        pageBean.setTotalRecode(totalRecode);

        StringBuilder listSql = new StringBuilder("select * from book");
        StringBuilder limitSql = new StringBuilder(" limit ?,?");
        System.out.println(listSql.append(whereSql).append(limitSql).toString());
        params.add((pageCode - 1) * pageSize);
        params.add(pageSize);
        System.out.println(params);

        List<Book> beanList = queryRunner.query(listSql.append(whereSql).append(limitSql).toString(),
                new BeanListHandler<Book>(Book.class),
                params.toArray());
        pageBean.setBeanList(beanList);
        return pageBean;
    }*/
}
