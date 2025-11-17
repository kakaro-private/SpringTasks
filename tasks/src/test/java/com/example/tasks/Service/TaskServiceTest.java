package com.example.tasks.Service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.tasks.Entity.TaskEntity;
import com.example.tasks.Form.TaskInputForm;
import com.example.tasks.Form.TaskListForm;
import com.example.tasks.Repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

  @Mock
  TaskRepository taskRepository;
  @InjectMocks
  TaskService taskService;
  TaskListForm listForm;
  TaskInputForm inputForm;
  int id;

  public List<TaskEntity> setUp() {
    List<TaskEntity> list = new ArrayList<>();
    TaskEntity high = new TaskEntity();
    TaskEntity middle = new TaskEntity();
    TaskEntity low = new TaskEntity();

    high.setId(1);
    high.setUserID("first");
    high.setTypeByTypeName("Work");
    high.setTaskName("highTask");
    high.setTaskDescription("this is highTask");
    high.setPriorityByLavel("High");
    high.setDueDate(LocalDate.parse("2025-01-01"));
    high.setIsCompleted(false);

    list.add(high);

    middle.setId(2);
    middle.setUserID("second");
    middle.setTypeByTypeName("Private");
    middle.setTaskName("middleTask");
    middle.setTaskDescription("this is middleTask");
    middle.setPriorityByLavel("Middle");
    middle.setDueDate(LocalDate.parse("2025-02-02"));
    middle.setIsCompleted(true);

    list.add(middle);

    low.setId(3);
    low.setUserID("third");
    low.setTypeByTypeName("Other");
    low.setTaskName("lowTask");
    low.setTaskDescription("this is lowTask");
    low.setPriorityByLavel("Low");
    low.setDueDate(LocalDate.parse("2025-03-03"));
    low.setIsCompleted(false);

    list.add(low);

    return list;

  }

  @BeforeEach
  public void beforeEach() {
    listForm = new TaskListForm();

    inputForm = new TaskInputForm();
    inputForm.setType("Other");
    inputForm.setTaskName("newTasks");
    inputForm.setTaskDescription("this is newTask");
    inputForm.setPriority("Middle");
    inputForm.setDueDate("2025-04-04");

    id = 0;

  }

  @Nested
  public class searchTasksTest {

    @Test
    void searchTasks() {
      List<TaskEntity> list = setUp();

      when(taskRepository.getTasks(listForm)).thenReturn(list);

      List<TaskEntity> result = taskService.searchTasks(listForm);

      assertThat(result.get(0).getId()).isEqualTo(1);
      verify(taskRepository, times(1)).getTasks(listForm);

    }

  }

  @Nested
  public class addTasksTest {

    @Test
    void addTasks() {
      doNothing().when(taskRepository).insertTasks(inputForm, null);

      taskService.addTasks(inputForm);

      verify(taskRepository, times(1)).insertTasks(inputForm, null);

    }

  }

  @Nested
  public class updateTasksTest {

    @Test
    void updateTasks() {
      doNothing().when(taskRepository).updateTasks(inputForm);

      taskService.updateTasks(inputForm);

      verify(taskRepository, times(1)).updateTasks(inputForm);

    }

  }

  @Nested
  public class completeTasksTest {

    @Test
    void completeTasks() {
      doNothing().when(taskRepository).completeTasks(id);

      taskService.completeTasks(id);

      verify(taskRepository, times(1)).completeTasks(id);

    }

  }

  @Nested
  public class deleteTasksTest {

    @Test
    void deleteTasks() {
      doNothing().when(taskRepository).deleteTasks(id);

      taskService.deleteTasks(id);

      verify(taskRepository, times(1)).deleteTasks(id);

    }

  }

}
