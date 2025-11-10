package com.example.tasks.Form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskInputForm {

  @NotNull
  private int id;
  @NotBlank
  private String type;
  @NotBlank
  private String taskName;
  @NotBlank
  private String taskDescription;
  @NotBlank
  private String priority;
  @NotNull
  private String deadline;

  //GetSet------------------------------------
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getDeadline() {
    return this.deadline;
  }

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

}
