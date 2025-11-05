package com.example.tasks.Form.util;

public class PageInfo {

  private int lineCount = 20;//表示件数、初期値20
  private int allCount;//全件数
  private int pageNo;//現在ページ数
  private int maxPage;//最大ページ数

  public int calcPages() {
    if (pageNo <= 0) {
      pageNo = 1;
    } else if (maxPage < pageNo) {
      pageNo = maxPage;
    }
    return pageNo;
  }

  //GetSet------------------------------------

  public int getLineCount() {
    return this.lineCount;
  }

  public void setLineCount(int lineCount) {
    this.lineCount = lineCount;

  }

  public int getAllCount() {
    return this.allCount;
  }

  public void setAllCount(int allCount) {
    this.allCount = allCount;

  }

  public int getPageNo() {
    return this.pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;

  }

  public int getMaxPage() {
    return this.maxPage;
  }

  public void setMaxPage(int maxPage) {
    this.maxPage = maxPage;

  }

}
