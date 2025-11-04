package com.example.tasks.Form;

import java.util.Date;

public class TaskInputForm {

  private String type;
  private String taskName;
  private String taskDescription;
  private String priority;
  private Date deadline;

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

  public String getTaskDescription() {
    return this.taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  public String getPriority() {
    return this.priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public Date getDeadline() {
    return this.deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

}
