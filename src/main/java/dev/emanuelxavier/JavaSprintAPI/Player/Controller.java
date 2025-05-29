package dev.emanuelxavier.JavaSprintAPI.Player;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/player")
public class Controller {

  private PlayerService playserService;

  public Controller(PlayerService playserService) {
    this.playserService = playserService;
  }

  @PostMapping("/create")
  public String create() {
    return "";
  }

  @GetMapping("/list")
  public List<PlayerModel> list() {
    return playserService.list();
  }

  @GetMapping("/player")
  public String searchByID() {
    return "";
  }

  @PutMapping("/player")
  public String update() {
    return "";
  }

  @DeleteMapping("/player")
  public String delete() {
    return "";
  }
}
