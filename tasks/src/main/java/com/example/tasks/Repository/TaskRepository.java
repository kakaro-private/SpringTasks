package com.example.tasks.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tasks.Entity.TaskEntity;
import com.example.tasks.Form.TaskInputForm;
import com.example.tasks.Form.TaskListForm;

@Repository
public class TaskRepository {

  @Autowired
  private TaskEntity taskEntity;
  @Autowired
  private TaskInputForm taskInputForm;
  @Autowired
  private TaskListForm taskListForm;
  private final JdbcTemplate jdbc;

  //DEBUG
  boolean dummy = false;

  TaskRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  //検索
  public List<TaskEntity> getTasks(TaskListForm form) {

    StringBuilder str = new StringBuilder("SELECT * FROM task");
    String where = null;

    //Where句の生成
    where = whereQueryBuild().toString();
    str.append(where);

    String sql = str.toString();
    List<Map<String, Object>> result = new ArrayList<>();

    //クエリ実行
    result = jdbc.queryForList(sql);

    //配列化
    List<TaskEntity> list = new ArrayList<>();
    for (Map<String, Object> Map : result) {
      TaskEntity entity = new TaskEntity();
      entity = MapToEntity(Map);
      list.add(entity);
    }

    return list;
  }

  public void insertTasks(TaskInputForm form) {

    String sql = "INSERT INTO task("
        + "type,"
        + "taskName,"
        + "taskDescription,"
        + "priority,"
        + "deadline)"
        + "VALUES ("
        + "?,"
        + "?,"
        + "?,"
        + "?,"
        + "?)";

    int n = 0;
    n = jdbc.update(sql, form.getType(), form.getTaskName(), form.getTaskDescription(),
        form.getPriority(), form.getDeadline());

    if (n != 1) {

    }

  }

  public void updateTasks(TaskInputForm form) {

    String sql = "UPDATE task SET"
        + "type = ?,"
        + "taskName = ?,"
        + "taskDescription = ?,"
        + "priority = ?,"
        + "deadline = ?"
        + "WHERE 'id' = ?";

    int n = 0;
    n = jdbc.update(sql, form.getType(), form.getTaskName(), form.getTaskDescription(),
        form.getPriority(), form.getDeadline(), "id");

    if (n != 1) {

    }
  }

  public void completeTasks(int id) {

    String sql = "UPDATE task SET"
        + "is_ccompleted = 1"
        + "WHERE 'id' = ?";

    int n = 0;
    n = jdbc.update(sql, id);

    if (n != 1) {

    }

  }

  public void deleteTasks(int id) {

    String sql = "DELETE FROM task"
        + "WHERE 'id' = ?";

    int n = 0;
    n = jdbc.update(sql, id);

    if (n != 1) {

    }

  }

  //MaptoEntityコンバータ
  public TaskEntity MapToEntity(Map<String, Object> map) {
    TaskEntity entity = new TaskEntity();

    entity.setId((Integer) map.get("id"));
    entity.setUserName(map.get("user_nama").toString());
    entity.setTypeByTypeName(map.get("type").toString());
    entity.setTaskName(map.get("task_name").toString());
    entity.setTaskDescription(map.get("description").toString());
    entity.setPriorityByLavel(map.get("priority").toString());
    entity.setDeadline((Date) map.get("deadline"));
    entity.setIsCompleted(((boolean) map.get("is_completed")));

    return entity;
  }

  //Where句を生成
  public String whereQueryBuild() {

    StringBuilder str = new StringBuilder("");

    //TODO:IF条件
    //Auth別処理
    String n = "0";
    String AuthFlag = "";
    switch (n) {
    case "Debug":
      break;
    case "Admin":
      if (dummy) {
        String authAdmin = "name = ?";
      }
      break;
    case "common":
      String suthCommon = "name = ?";
      break;
    }

    //idCompleted=1or0のみ条件
    if (dummy) {
      String comp = " is_completed = 1";
    } else {
      String compNot = "is_completed = 0";
    }

    //Priority = ?条件
    if (dummy) {
      String priHigh = "priority = 'High'";
    } else if (dummy) {
      String priMid = "priority = 'Middle'";
    } else if (dummy) {
      String priLow = "priority = 'Low'";
    }

    return null;
  }

}
