package com.example.tasks.Entity;

import java.time.LocalDateTime;

public class UserEntity {

  /*
   * 権限を定義
   */
  private enum Auth {
    admin("管理者"), common("一般"), debug("デバッグ");

    private final String level;

    Auth(String level) {
      this.level = level;
    }

    public String getLevel() {

      return this.level;
    }
  }

  private String loginId;
  private String userName;
  private String pass;
  private Auth auth = Auth.common;//デフォルト値
  private LocalDateTime insertDate;
  private LocalDateTime updateDate;

  //GetSet------------------------------------

  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public Auth getAuth() {
    return auth;
  }

  public void setAuth(Auth auth) {
    this.auth = auth;
  }

  //String型からAuthを取得するメソッド
  public void setAuthByAuth(String auth) {

    switch (auth) {
    case "Admin":
      this.auth = Auth.admin;
      break;
    case "Middle":
      this.auth = Auth.common;
      break;
    case "Low":
      this.auth = Auth.debug;
      break;
    }

  }

  public LocalDateTime getInsertDate() {
    return insertDate;
  }

  public void setInsertDate(LocalDateTime insertDate) {
    this.insertDate = insertDate;
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(LocalDateTime updateDate) {
    this.updateDate = updateDate;
  }

  //デバッグ用
  public String getAuthLevel() {
    return this.auth.getLevel();
  }

}
