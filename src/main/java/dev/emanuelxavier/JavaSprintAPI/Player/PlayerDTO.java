package dev.emanuelxavier.JavaSprintAPI.Player;

import dev.emanuelxavier.JavaSprintAPI.Mission.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerDTO {
  private Long id;
  private String username;
  private String email;
  private int lvl;
  private MissionModel mission;
  private String rank;
}
