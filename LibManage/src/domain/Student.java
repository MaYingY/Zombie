package domain;

/**
 * Created by dell on 17-5-24.
 */
public class Student {
    public int id;
    public String name;
    public String password;
    public int money;
    public int bookcount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBookcount() {
        return bookcount;
    }

    public void setBookcount(int bookcount) {
        this.bookcount = bookcount;
    }
}
