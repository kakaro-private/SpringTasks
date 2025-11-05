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
import com.example.tasks.Form.util.PageInfo;

@Repository
public class TaskRepository {

  @Autowired
  private final JdbcTemplate jdbc;

  private PageInfo pageInfo;

  //DEBUG
  boolean dummy = false;

  TaskRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  /*
   * 検索
   */
  public List<TaskEntity> getTasks(TaskListForm form) {

    pageInfo = form.getPageInfo();
    //全件数の取得
    pageInfo.setAllCount(jdbc.queryForObject("SELECT COUNT(*) FROM task", Integer.class));
    //表示ページ数の計算
    pageInfo.setPageNo(pageInfo.calcPages());

    //sql生成
    StringBuilder str = new StringBuilder("SELECT "
        + " 'id',"
        + " 'type',"
        + " 'task_name',"
        + " 'task_description',"
        + " 'priority',"
        + " 'deedline',"
        + " 'is_completed'"
        + " FROM task");

    String where = null;

    //Where句の生成
    where = whereQueryBuild().toString();
    str.append(where);

    String sql = str.toString();
    List<Map<String, Object>> result = new ArrayList<>();

    //クエリ実行
    result = jdbc.queryForList(sql);

    //コンバート
    List<TaskEntity> list = new ArrayList<>();
    for (Map<String, Object> Map : result) {
      TaskEntity entity = new TaskEntity();
      entity = MapToEntity(Map);
      list.add(entity);
    }

    return list;
  }

  /*
   * 挿入
   */
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
    n = jdbc.update(sql,
        form.getType(),
        form.getTaskName(),
        form.getTaskDescription(),
        form.getPriority(),
        form.getDeadline());

    if (n != 1) {

    }

  }

  /*
   * 更新
   */
  public void updateTasks(TaskInputForm form) {

    String sql = "UPDATE task SET"
        + "type = ?,"
        + "taskName = ?,"
        + "taskDescription = ?,"
        + "priority = ?,"
        + "deadline = ?"
        + "WHERE 'id' = ?";

    int n = 0;
    n = jdbc.update(sql,
        form.getType(),
        form.getTaskName(),
        form.getTaskDescription(),
        form.getPriority(),
        form.getDeadline(),
        form.getId());

    if (n != 1) {

    }
  }

  /*
   * 
   */
  public void completeTasks(int id) {

    String sql = "UPDATE task SET"
        + "is_ccompleted = 1"
        + "WHERE 'id' = ?";

    int n = 0;
    n = jdbc.update(sql, id);

    if (n != 1) {

    }

  }

  /*
   * 
   */
  public void deleteTasks(int id) {

    String sql = "DELETE FROM task"
        + "WHERE 'id' = ?";

    int n = 0;
    n = jdbc.update(sql, id);

    if (n != 1) {

    }

  }

  /*
   * MaptoEntityコンバータ
   */
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

  /*
   * Where句を生成
   */
  public String whereQueryBuild() {

    StringBuilder str = new StringBuilder("");

    //TODO:loginUserのAuthを判別してSwitch
    //Auth別処理
    String n = "0";
    String auth = "";
    switch (n) {
    case "Debug":
    case "Admin":
      if (dummy) {//cmdによって判別
        auth = "name = ?";
      }
      break;
    case "common":
      auth = "name = ?";
      break;
    }

    //idCompleted=1or0のみ条件
    String comp = "";
    if (dummy) {
      if (dummy) {
        comp = " is_completed = 1";
      } else {
        comp = "is_completed = 0";
      }
    }

    //Priority = ?条件
    String pri = "";
    String priority = "";
    if (dummy) {
      switch (pri) {
      case "High":
        priority = "priority = High";
        break;
      case "Middle":
        priority = "priority = Middle";
        break;
      case "Low":
        priority = "priority = Middle";
        break;
      }
    }

    if (!auth.isBlank() && !comp.isBlank() && !priority.isBlank()) {
      str.append("WHERE");

    }

    return null;
  }

}
