package com.example.tasks.Form.util;

public class PageInfo {

  private int lineCount = 20;//表示件数、初期値20
  private int allCount;//全件数
  private int pageCount;//現在ページ数
  private int maxPage;//最大ページ数

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

  public int getPageCount() {
    return this.pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;

  }

  public int getMaxPage() {
    return this.maxPage;
  }

  public void setMaxPage(int maxPage) {
    this.maxPage = maxPage;

  }

}
