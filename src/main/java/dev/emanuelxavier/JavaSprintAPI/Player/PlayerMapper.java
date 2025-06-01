package dev.emanuelxavier.JavaSprintAPI.Player;

import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
  public PlayerModel map(PlayerDTO playerDTO) {
    PlayerModel pModel = new PlayerModel();
    pModel.setId(playerDTO.getId());
    pModel.setUsername(playerDTO.getUsername());
    pModel.setEmail(playerDTO.getEmail());
    pModel.setLvl(playerDTO.getLvl());
    pModel.setMission(playerDTO.getMission());
    pModel.setRank(playerDTO.getRank());

    return pModel;
  }

  public PlayerDTO map(PlayerModel playerModel) {
    PlayerDTO pDTO = new PlayerDTO();
    pDTO.setId(playerModel.getId());
    pDTO.setUsername(playerModel.getUsername());
    pDTO.setEmail(playerModel.getEmail());
    pDTO.setLvl(playerModel.getLvl());
    pDTO.setMission(playerModel.getMission());
    pDTO.setRank(playerModel.getRank());

    return pDTO;
  }
}
