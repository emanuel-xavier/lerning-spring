package dev.emanuelxavier.JavaSprintAPI.Player;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<String> create(@RequestBody PlayerDTO player) {
    PlayerDTO playerDTO = playserService.create(player);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("playser created with id:" + playerDTO.getId());
  }

  @GetMapping("/list")
  public ResponseEntity<List<PlayerDTO>> list() {
    List<PlayerDTO> players = playserService.list();

    return ResponseEntity.status(HttpStatus.OK)
        .body(players);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findByID(@PathVariable Long id) {
    PlayerDTO player = playserService.findByID(id);
    if (player == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    return ResponseEntity.ok(player);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PlayerDTO newPlayer) {
    PlayerDTO player = playserService.update(id, newPlayer);

    if (player == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    return ResponseEntity.ok(player);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    if (playserService.findByID(id) == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("player with id " + id + " not found");
    }

    playserService.deleteById(id);
    return ResponseEntity.ok("player with id " + id + " was deleted successfully");

  }
}
