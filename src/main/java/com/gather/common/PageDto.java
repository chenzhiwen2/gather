package com.gather.common;

public class PageDto {
    private Integer page;

    private Integer pageSize;

    private int total;

    public PageDto(Integer page, Integer pageSize, int total) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}