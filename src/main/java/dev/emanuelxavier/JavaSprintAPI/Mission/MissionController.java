package dev.emanuelxavier.JavaSprintAPI.Mission;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mission")
@Tag(name = "Mission", description = "Endpoints for managing missions")
public class MissionController {

  private final MissionService missionService;

  public MissionController(MissionService missionService) {
    this.missionService = missionService;
  }

  @GetMapping("/list")
  @Operation(summary = "List all missions", description = "Returns all registered missions")
  public ResponseEntity<List<MissionDTO>> list() {
    List<MissionDTO> missions = missionService.list();
    return ResponseEntity.ok(missions);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Find a mission by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Mission found"),
      @ApiResponse(responseCode = "404", description = "Mission not found")
  })
  public ResponseEntity<?> searchById(
      @Parameter(description = "ID of the mission to retrieve") @PathVariable Long id) {
    MissionDTO mission = missionService.findByID(id);

    if (mission == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    return ResponseEntity.ok(mission);
  }

  @PostMapping("/create")
  @Operation(summary = "Create a new mission")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Mission successfully created"),
      @ApiResponse(responseCode = "400", description = "Failed to create mission")
  })
  public ResponseEntity<?> create(
      @Parameter(description = "Payload with new mission data") @RequestBody MissionDTO mission) {
    MissionDTO createdMission = missionService.create(mission);

    if (createdMission == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not create the mission");
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(createdMission);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update an existing mission")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Mission successfully updated"),
      @ApiResponse(responseCode = "404", description = "Mission not found")
  })
  public ResponseEntity<?> update(
      @Parameter(description = "ID of the mission to update") @PathVariable Long id,
      @Parameter(description = "Updated mission data") @RequestBody MissionDTO newPlayer) {
    MissionDTO mission = missionService.update(id, newPlayer);

    if (mission == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    return ResponseEntity.ok(mission);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a mission by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Mission successfully deleted"),
      @ApiResponse(responseCode = "404", description = "Mission not found")
  })
  public ResponseEntity<String> deleteById(
      @Parameter(description = "ID of the mission to delete") @PathVariable Long id) {
    if (missionService.findByID(id) == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("mission with id " + id + " not found");
    }

    missionService.deleteById(id);
    return ResponseEntity.ok("mission with id " + id + " was deleted successfully");
  }
}
