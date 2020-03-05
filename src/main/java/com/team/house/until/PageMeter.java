package com.team.house.until;

public class PageMeter {
    private Integer page = 1; //页码
    private Integer pageSize = 4;//页大小

    private Long devid;

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
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
}
