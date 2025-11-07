package com.example.tasks.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tasks.Entity.TaskEntity;
import com.example.tasks.Form.TaskInputForm;
import com.example.tasks.Form.TaskListForm;
import com.example.tasks.Service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

  @Autowired
  TaskService taskService;

  @GetMapping("/list")
  public String getList(Model model) {

    TaskListForm form = new TaskListForm();
    List<TaskEntity> list = taskService.searchTasks(form);

    model.addAttribute("taskListForm", form);
    model.addAttribute("taskList", list);

    return "task_list";

  }

  @PostMapping("/list")
  public String postList(@ModelAttribute TaskListForm form, Model model) {

    List<TaskEntity> list = taskService.searchTasks(form);

    model.addAttribute("taskListForm", form);
    model.addAttribute("taskList", list);

    return "task_list";

  }

  @PostMapping("/new")
  public String postListNew(Model model) {

    TaskInputForm form = new TaskInputForm();

    model.addAttribute("taskInputForm", form);
    model.addAttribute("actionCmd", "new");

    return "task_register";

  }

  @PostMapping("/new/confirm")
  public String postListNewConfirm(@Valid @ModelAttribute TaskInputForm form, BindingResult bindingResult,
      Model model) {

    if (bindingResult.hasErrors()) {

      model.addAttribute("taskInputForm", form);
      model.addAttribute("actionCmd", "new");

      return "task_register";

    }

    model.addAttribute("taskInputForm", form);
    model.addAttribute("actionCmd", "new");

    return "task_confirm";

  }

  @PostMapping("/new/complete")
  public String postListNewComplete() {

    return "task_list";

  }

  @PostMapping("/update")
  public String postListUpdate(@ModelAttribute int id, Model model) {

    TaskInputForm form = taskService.searchTasksSingle(id);

    model.addAttribute("taskInputForm", form);
    model.addAttribute("actionCmd", "update");

    return "task_register";

  }

  @PostMapping("/update/confirm")
  public String postListUpdateConfirm() {

    return "task_confirm";

  }

  @PostMapping("/update/complete")
  public String postListUpdateComplete() {

    return "task_list";

  }

  @PostMapping("/list/complete")
  public String postListCompleted() {

    return null;

  }

  @PostMapping("/list/delete")
  public String postListDelete() {

    return null;

  }

  @PostMapping("/list/delete/complete")
  public String postListDeleteComplete() {

    return null;

  }

}
