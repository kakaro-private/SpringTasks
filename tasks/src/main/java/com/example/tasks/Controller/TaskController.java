package com.example.tasks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/task")
public class TaskController {

  @GetMapping("/list")
  public String getList() {

    return null;

  }

  @PostMapping("/list")
  public String postList() {

    return null;

  }

  @PostMapping("/list/new")
  public String postListNew() {

    return null;

  }

  @PostMapping("/list/new/confirm")
  public String postListNewConfirm() {

    return null;

  }

  @PostMapping("/list/new/complete")
  public String postListNewComplete() {

    return null;

  }

  @PostMapping("/list/update")
  public String postListUpdate() {

    return null;

  }

  @PostMapping("/list/update/confirm")
  public String postListUpdateConfirm() {

    return null;

  }

  @PostMapping("/list/update/complete")
  public String postListUpdateComplete() {

    return null;

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
