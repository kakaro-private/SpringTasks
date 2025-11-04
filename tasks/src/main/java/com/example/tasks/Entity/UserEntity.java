package com.example.tasks.Entity;

import jakarta.validation.constraints.NotBlank;

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

  @NotBlank
  private int id;
  @NotBlank
  private String userName;
  private String pass;
  @NotBlank
  private Auth auth = Auth.common;//デフォルト値

  //GetSet------------------------------------
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPass() {
    return this.pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public Auth getAuth() {
    return this.auth;
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

  //デバッグ用
  public String getAuthLevel() {
    return this.auth.getLevel();
  }

}
