package com.essg.common.part;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class PageResult<T>  implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;
    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;


    public PageResult() {
    }

    public PageResult(Page page)
    {
        if(page == null)
            throw new NullPointerException("page");
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();

        this.pages= page.getPages();
        this.list = page;
        this.total = page.getTotal();
    }


    public PageResult(List<T> list) {
        this.pageSize = list.size();

        this.pageNum = 1;
        this.list = list;
        this.total = list.size();
        //判断页面边界
        judgePageBoudary();
    }

    public PageResult(List<T> list, int pageNum, int pageSize, int total) {
        this.pageSize = pageSize;

        this.pageNum = pageNum;
        this.list = list;
        this.total = total;
        //判断页面边界
        judgePageBoudary();
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    @Override
    public String toString() {
        final StringBuilder strBuf = new StringBuilder("PageResult{");
        strBuf.append("pageNum=").append(pageNum);
        strBuf.append(", pageSize=").append(pageSize);
        strBuf.append(", total=").append(total);
        strBuf.append(", pages=").append(pages);
        strBuf.append(", list=").append(list);
        strBuf.append(", isFirstPage=").append(isFirstPage);
        strBuf.append(", isLastPage=").append(isLastPage);
        strBuf.append(", navigatepageNums=");
        strBuf.append('}');
        return strBuf.toString();
    }
}
