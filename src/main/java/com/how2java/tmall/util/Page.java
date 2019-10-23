package com.how2java.tmall.util;

import org.jetbrains.annotations.Contract;

public class Page {
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int start;  //開始頁數
    private int count;  //每頁顯示頁數
    private int total;  //總個數

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    private String param; //參數

    private static final int defaultCount;

    // 每頁5條
    static {
        defaultCount = 5;
    }

    public Page() {
        count = defaultCount;
    }

    public Page(int start, int count) {
        this();
        this.start = start;
        this.count = count;
    }


    public boolean isHasPreviouse(){
        if(start==0)
            return false;
        return true;
    }


    public boolean isHasNext() {
        if (start == getLast())
            return false;
        return true;
    }

    public int getTotalPage() {
        int totalPage;
        if (0 == total % count)
            totalPage = total / count;
        else
            totalPage = total / count + 1;
        if (0 == totalPage)
            totalPage = 1;
        return totalPage;
    }

    public int getLast() {
        int last;
        if (total % count == 0)
            last = total - count;
        else
            last = total - total % count;
        last = (last < 0) ? 0 : last;
        return last;
    }
    @Override
    public String toString()   {
        return "Page [start=" + start + ", count=" + count + ", total=" + total + ", getStart()=" + getStart()
                + ", getCount()=" + getCount() + ", isHasPreviouse()=" + isHasPreviouse() + ", isHasNext()="
                + isHasNext() + ", getTotalPage()=" + getTotalPage() + ", getLast()=" + getLast() + "]";
    }

}
