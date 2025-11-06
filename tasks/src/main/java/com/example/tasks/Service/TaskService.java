package com.example.tasks.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tasks.Entity.TaskEntity;
import com.example.tasks.Form.TaskInputForm;
import com.example.tasks.Form.TaskListForm;
import com.example.tasks.Repository.TaskRepository;

@Service
public class TaskService {

  @Autowired
  TaskRepository taskRepository;

  /*
   * 検索
   */
  @Transactional(readOnly = true)
  public List<TaskEntity> searchTasks(TaskListForm form) {
    List<TaskEntity> list = taskRepository.getTasks(form);
    return list;
  }

  /*
   * タスク追加
   * for common user
   */
  @Transactional
  public void addTasks(TaskInputForm form) {
    String userName = "loginUserName";//TODO:修正
    taskRepository.insertTasks(form, userName);

  }

  /*
   * タスク追加
   * for admin user
   */
  @Transactional
  public void addTasksAdmin(TaskInputForm form) {
    String userName = "taskUserName";//TODO:修正
    taskRepository.insertTasks(form, userName);

  }

  /*
   * タスクの修正
   */
  @Transactional
  public void updateTasks(TaskInputForm form) {
    taskRepository.updateTasks(form);
  }

  //状態ラベルを｢完了へ｣
  @Transactional
  public void completeTasks(int id) {
    taskRepository.completeTasks(id);
  }

  //削除
  @Transactional
  public void deleteTasks(int id) {
    taskRepository.deleteTasks(id);

  }

}
