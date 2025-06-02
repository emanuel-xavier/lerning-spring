package dev.emanuelxavier.JavaSprintAPI.Mission;

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
@RequestMapping(path = "/mission")
public class MissionController {
  private MissionService missionService;

  public MissionController(MissionService missionService) {
    this.missionService = missionService;
  }

  @GetMapping("/list")
  public ResponseEntity<List<MissionDTO>> list() {
    List<MissionDTO> missions = missionService.list();

    return ResponseEntity.ok(missions);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> searchById(@PathVariable Long id) {
    MissionDTO mission = missionService.findByID(id);

    if (mission == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    return ResponseEntity.ok(mission);
  }

  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody MissionDTO mission) {
    MissionDTO createdMission = missionService.create(mission);

    if (createdMission == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not create the mission");
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(createdMission);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MissionDTO newPlayer) {
    MissionDTO mission = missionService.update(id, newPlayer);

    if (mission == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    return ResponseEntity.ok(mission);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    if (missionService.findByID(id) == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("mission with id " + id + " not found");
    }

    missionService.deleteById(id);
    return ResponseEntity.ok("mission with id " + id + " was deleted successfully");

  }

}
