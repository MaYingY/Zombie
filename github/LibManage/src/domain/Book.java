package domain;

/**
 * Created by dell on 17-5-24.
 */
public class Book {
    public int id;
    public String name;
    public String type;
    public Double price;
    public String publishingHouse;
    public String author;
    public int bookCount;
    public Double dayMoney;
    public int flag;
    public int agoCount;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public Double getDayMoney() {
        return dayMoney;
    }

    public void setDayMoney(Double dayMoney) {
        this.dayMoney = dayMoney;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getAgoCount() {
        return agoCount;
    }

    public void setAgoCount(int agoCount) {
        this.agoCount = agoCount;
    }
}
