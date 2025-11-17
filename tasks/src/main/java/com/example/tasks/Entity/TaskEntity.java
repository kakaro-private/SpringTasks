package com.example.tasks.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

  public enum Status {
    TODO, Finish
  }

  private int id;
  private String userID;
  private Type type = Type.Other;//==デフォルト値
  private String taskName;
  private String taskDescription;
  private Priority priority = Priority.Low;//==デフォルト値
  private LocalDate dueDate;
  private boolean isCompleted = false;//==デフォルト値
  private boolean isDeleted = false;//==デフォルト値
  private LocalDateTime insertAt;
  private LocalDateTime updatedAt;

  //GetSet------------------------------------

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public Type getType() {
    return type;
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
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskDescription() {
    return taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  public Priority getPriority() {
    return priority;
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

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public boolean getIsCompleted() {
    return isCompleted;
  }

  public void setIsCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  public boolean getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public LocalDateTime getInsertAt() {
    return insertAt;
  }

  public void setInsertAt(LocalDateTime insertAt) {
    this.insertAt = insertAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

}
