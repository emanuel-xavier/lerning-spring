package dev.emanuelxavier.JavaSprintAPI.Player;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/player")
public class PlayerController {

  private PlayerService playserService;

  public PlayerController(PlayerService playserService) {
    this.playserService = playserService;
  }

  @PostMapping("/create")
  public PlayerDTO create(@RequestBody PlayerDTO player) {
    return playserService.create(player);
  }

  @GetMapping("/list")
  public List<PlayerDTO> list() {
    return playserService.list();
  }

  @GetMapping("/{id}")
  public PlayerDTO findByID(@PathVariable Long id) {
    return playserService.findByID(id);
  }

  @PutMapping("/{id}")
  public PlayerDTO update(@PathVariable Long id, @RequestBody PlayerDTO newPlayer) {
    return playserService.update(id, newPlayer);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    playserService.deleteById(id);
  }
}
