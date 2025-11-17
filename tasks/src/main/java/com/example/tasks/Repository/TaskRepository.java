package com.example.tasks.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
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
        + " id,"
        + " user_name,"
        + " type,"
        + " task_name,"
        + " task_description,"
        + " priority,"
        + " deadline,"
        + " is_completed"
        + " FROM task");

    //Where句の生成
    String where = "";
    where = whereQueryBuild();
    if (!where.equals("")) {
      where.toString();
      str.append(where);
    }

    //クエリ実行
    String sql = str.toString();
    List<Map<String, Object>> result = new ArrayList<>();
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
   *一件を検索
   */
  public TaskEntity getTasksSingle(int id) {

    String sql = new String("SELECT "
        + " id,"
        + " user_name,"
        + " type,"
        + " task_name,"
        + " task_description,"
        + " priority,"
        + " deadline,"
        + " is_completed"
        + " FROM task"
        + " WHERE id = ? ");

    //クエリ実行
    Map<String, Object> result = new HashMap<>();
    result = jdbc.queryForMap(sql, id);

    //コンバート
    TaskEntity entity = new TaskEntity();
    entity = MapToEntity(result);

    return entity;
  }

  /*
   * 挿入
   */
  public void insertTasks(TaskInputForm form, String userName) {

    String sql = "INSERT INTO task("
        + "user_name,"
        + "type,"
        + "task_name,"
        + "task_description,"
        + "priority,"
        + "deadline,"
        + "is_completed)"
        + "VALUES ("
        + "?,"
        + "?,"
        + "?,"
        + "?,"
        + "?,"
        + "?,"
        + "?)";

    int low = 0;
    low = jdbc.update(sql,
        userName,
        form.getType(),
        form.getTaskName(),
        form.getTaskDescription(),
        form.getPriority(),
        form.getDeadline(),
        false);

    if (low != 1) {
      //TODO:エラー処理
    }

  }

  /*
   * 更新
   */
  public void updateTasks(TaskInputForm form) {

    String sql = "UPDATE spring_tasks.task SET "
        + " type = ?,"
        + " task_name = ?,"
        + " task_description = ?,"
        + " priority = ?,"
        + " deadline = ?"
        + " WHERE id = ?";

    int low = 0;
    low = jdbc.update(sql,
        form.getType(),
        form.getTaskName(),
        form.getTaskDescription(),
        form.getPriority(),
        form.getDeadline(),
        form.getId());

    if (low != 1) {
      //TODO:エラー処理
    }
  }

  /*
   * 完了
   */
  public void completeTasks(int id) {

    String sql = "UPDATE task SET"
        + "is_ccompleted = 1"
        + "WHERE 'id' = ?";

    int low = 0;
    low = jdbc.update(sql, id);

    if (low != 1) {
      //TODO:エラー処理
    }

  }

  /*
   * 削除
   */
  public void deleteTasks(int id) {

    String sql = "DELETE FROM task"
        + "WHERE 'id' = ?";

    int low = 0;
    low = jdbc.update(sql, id);

    if (low != 1) {
      //TODO:エラー処理
    }

  }

  /*
   * MaptoEntityコンバータ
   */
  public TaskEntity MapToEntity(Map<String, Object> map) {
    TaskEntity entity = new TaskEntity();

    //DEBUG
    //    System.out.println(map.get("id").toString());
    //    System.out.println(map.get("user_name").toString());

    entity.setId(Integer.valueOf(map.get("id").toString()));
    entity.setUserID(map.get("user_id").toString());
    entity.setTaskName(map.get("task_name").toString());
    entity.setTypeByTypeName(map.get("type").toString());
    entity.setPriorityByLavel(map.get("priority").toString());
    entity.setDueDate(((Date) map.get("due_date")).toLocalDate());
    entity.setInsertAt(((Timestamp) map.get("insert_at")).toLocalDateTime());
    entity.setUpdatedAt(((Timestamp) map.get("updated_at")).toLocalDateTime());
    entity.setIsCompleted(((boolean) map.get("is_completed")));
    entity.setIsDeleted(((boolean) map.get("is_deleted")));
    entity.setTaskDescription(map.get("task_description").toString());

    return entity;
  }

  /*
   * Where句を生成
   */
  public String whereQueryBuild() {

    StringBuilder str = new StringBuilder("");

    //TODO:loginUserのAuthを判別してSwitch
    //Auth別処理
    String n = "";
    String auth = "";
    switch (n) {
    case "Debug":
    case "Admin":
      if (dummy) {//cmdによって判別
        auth = "name = " + "userName";
      }
      break;
    case "common":
      auth = "name = " + "userName";
      break;
    }

    //idCompleted=1or0のみ条件
    String comp = "";
    if (dummy) {
      switch (comp) {
      case "true":
        comp = "is_completed = true";
        break;
      case "false":
        comp = "is_completed = false";
        break;
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

    var result = str.toString();

    return result;
  }

}
