package dev.emanuelxavier.JavaSprintAPI.Mission;

import java.util.List;

import dev.emanuelxavier.JavaSprintAPI.Player.PlayerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissionDTO {
  private Long id;
  private String name;
  private int minLvl;
  private List<Long> participants;
}
