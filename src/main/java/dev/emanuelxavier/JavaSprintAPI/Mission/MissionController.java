package dev.emanuelxavier.JavaSprintAPI.Mission;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "mission")
public class MissionController {

  @GetMapping("/list")
  public String list() {
    return "";
  }

  @GetMapping("/mission")
  public String searchById() {
    return "";
  }

  @PostMapping("/create")
  public String create() {
    return "";
  }

  @DeleteMapping("/delete")
  public String delete() {
    return "";
  }

  @PutMapping("/update")
  public String update() {
    return "";
  }
}
