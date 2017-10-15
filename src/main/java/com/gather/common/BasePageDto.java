package com.gather.common;

import java.util.List;

public class BasePageDto<T> {
    private List<T> list;

    private PageDto pageInfo;

    public List<T> getList() {
        return list;
    }

    public BasePageDto(List<T> list, PageDto pageInfo) {
        this.list = list;
        this.pageInfo = pageInfo;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageDto getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageDto pageInfo) {
        this.pageInfo = pageInfo;
    }
}

