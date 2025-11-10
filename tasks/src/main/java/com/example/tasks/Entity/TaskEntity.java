package com.example.tasks.Entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class TaskEntity {

  /*
   * 種別を定義
   */
  public enum Type {
    Work, Private, Other;
  }

  /*
   * 優先度を定義
   * 高、中、低の3段階
   */
  public enum Priority {
    High, Middle, Low;

  }

  @NotBlank
  private int id;
  @NotBlank
  private String userName;
  @NotBlank
  private Type type = Type.Other;//==デフォルト値
  @NotBlank
  private String taskName;
  private String taskDescription;
  @NotBlank
  private Priority priority = Priority.Low;//==デフォルト値
  @NotBlank
  private LocalDate deadline;
  @NotBlank
  private boolean isCompleted = false;//==デフォルト値

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

  public LocalDate getDeadline() {
    return this.deadline;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }

  public boolean getIsCompleted() {
    return this.isCompleted;
  }

  public void setIsCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;

  }

}
