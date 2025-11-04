package com.example.tasks.Form;

import jakarta.validation.constraints.NotBlank;

public class TaskListForm {

  @NotBlank
  private String userName;
  @NotBlank
  private String type;
  @NotBlank
  private String taskName;
  @NotBlank
  private String priority;
  @NotBlank
  private boolean isCompleted;

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTaskName() {
    return this.taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getPriority() {
    return this.priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public boolean getIsCompleted() {
    return this.isCompleted;
  }

  public void setIsCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

}
