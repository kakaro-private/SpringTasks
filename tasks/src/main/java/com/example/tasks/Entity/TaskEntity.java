package com.example.tasks.Entity;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public class TaskEntity {

  /*
   * 種別を定義
   */
  public enum Type {
    Work("work"), Private("private"), Other("other");

    private final String typeName;

    Type(String typeName) {
      this.typeName = typeName;
    }

    public String getTypeName() {
      return this.typeName;
    }

  }

  /*
   * 優先度をラベルにして規定
   * 高、中、低の3段階
   */
  public enum Priority {
    High("高"), Middle("中"), Low("低");

    private final String lavel;

    Priority(String lavel) {

      this.lavel = lavel;
    }

    public String getLavel() {
      return lavel;
    }

    public Priority fromLavel(String lavel) {
      for (Priority priority : Priority.values()) {
        if (priority.getLavel() == lavel) {
          return priority;
        }
      }
      throw new IllegalArgumentException("Unknown theme lavel: " + lavel);
    }

  }

  @NotBlank
  private int id;
  @NotBlank
  private String userName;
  @NotBlank
  private Type type = Type.Other;//デフォルト値
  @NotBlank
  private String taskName;
  @NotBlank
  private String taskDescription;
  @NotBlank
  private Priority priority = Priority.Low;//デフォルト値
  @NotBlank
  private Date deadline;
  @NotBlank
  private boolean isCompleted = false;//デフォルト値

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

  public Type getType() {
    return this.type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  //String型からTypeを指定出来るメソッド
  public void setTypeByTypeName(String type) {

    switch (type) {
    case "Work":
      this.type = Type.Work;
      break;
    case "Private":
      this.type = Type.Private;
      break;
    case "Other":
      this.type = Type.Other;
      break;
    }

  }

  public String getTaskName() {
    return this.taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskDescription() {
    return this.taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  public Priority getPriority() {
    return this.priority;
  }

  public void setPriority(Priority priority) {

    this.priority = priority;
  }

  //String型からPriorityを指定出来るメソッド
  public void setPriorityByLavel(String lavel) {

    switch (lavel) {
    case "High":
      this.priority = Priority.High;
      break;
    case "Middle":
      this.priority = Priority.Middle;
      break;
    case "Low":
      this.priority = Priority.Low;
      break;
    }

  }

  public Date getDeadline() {
    return this.deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

  public boolean getIsCompleted() {
    return this.isCompleted;
  }

  public void setIsCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;

  }

  //デバッグ用
  public String getLavel() {
    return this.priority.getLavel();
  }

  public String getTypeName() {
    return this.type.getTypeName();
  }

}
