package dev.emanuelxavier.JavaSprintAPI.Player;

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
@RequestMapping(path = "/player")
@Tag(name = "Player", description = "Endpoints for managing players")
public class PlayerController {

  private final PlayerService playserService;

  public PlayerController(PlayerService playserService) {
    this.playserService = playserService;
  }

  @PostMapping("/create")
  @Operation(summary = "Create a new player")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Player successfully created")
  })
  public ResponseEntity<String> create(
      @Parameter(description = "Payload with new player data") @RequestBody PlayerDTO player) {
    PlayerDTO playerDTO = playserService.create(player);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("player created with id: " + playerDTO.getId());
  }

  @GetMapping("/list")
  @Operation(summary = "List all players")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Players successfully retrieved")
  })
  public ResponseEntity<List<PlayerDTO>> list() {
    List<PlayerDTO> players = playserService.list();
    return ResponseEntity.status(HttpStatus.OK).body(players);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Find a player by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Player found"),
      @ApiResponse(responseCode = "404", description = "Player not found")
  })
  public ResponseEntity<?> findByID(
      @Parameter(description = "ID of the player to retrieve") @PathVariable Long id) {
    PlayerDTO player = playserService.findByID(id);
    if (player == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    return ResponseEntity.ok(player);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update a player by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Player successfully updated"),
      @ApiResponse(responseCode = "404", description = "Player not found")
  })
  public ResponseEntity<?> update(
      @Parameter(description = "ID of the player to update") @PathVariable Long id,
      @Parameter(description = "Updated player data") @RequestBody PlayerDTO newPlayer) {
    PlayerDTO player = playserService.update(id, newPlayer);

    if (player == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }

    return ResponseEntity.ok(player);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a player by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Player successfully deleted"),
      @ApiResponse(responseCode = "404", description = "Player not found")
  })
  public ResponseEntity<String> deleteById(
      @Parameter(description = "ID of the player to delete") @PathVariable Long id) {
    if (playserService.findByID(id) == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("player with id " + id + " not found");
    }

    playserService.deleteById(id);
    return ResponseEntity.ok("player with id " + id + " was deleted successfully");
  }
}
