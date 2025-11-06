package com.example.tasks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

  @GetMapping("/list")
  public String getList() {

    return "task_list";

  }

  @PostMapping("/list")
  public String postList() {

    return "task_list";

  }

  @PostMapping("/new")
  public String postListNew() {

    return "task_register";

  }

  @PostMapping("/new/confirm")
  public String postListNewConfirm() {

    return "task_confirm";

  }

  @PostMapping("/new/complete")
  public String postListNewComplete() {

    return "task_list";

  }

  @PostMapping("/update")
  public String postListUpdate() {

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
