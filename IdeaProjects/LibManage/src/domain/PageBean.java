package domain;

import java.util.List;

/**
 * Created by dell on 17-5-27.
 */

public class PageBean<T> {
    private int pageCode;
    private int totalRecode;
    private int pageSize;
    private List<T> beanList;
    private String url;

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalRecode() {
        return totalRecode;
    }

    public void setTotalRecode(int totalRecode) {
        this.totalRecode = totalRecode;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotalPage() {
        int totalPage = totalRecode / pageSize;
        return totalRecode%pageSize == 0 ? totalPage : totalPage + 1;
    }
}
