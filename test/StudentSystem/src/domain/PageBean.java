package domain;

import java.util.List;

/**
 * Created by zzp on 2017/2/22.
 */
public class PageBean<T> {
    private int pageCode;
    private int totalRecode;
    private int pageSize;
    private List<T> beanList;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public void setTotalRecode(int totalRecode) {
        this.totalRecode = totalRecode;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public int getPageCode() {
        return pageCode;
    }

    public int getTotalPage() {
        int totalPage = totalRecode / pageSize;
        return totalRecode%pageSize == 0 ? totalPage : totalPage + 1;
    }

    public int getTotalRecode() {
        return totalRecode;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }
}
