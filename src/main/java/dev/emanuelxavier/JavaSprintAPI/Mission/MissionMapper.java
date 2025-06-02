package dev.emanuelxavier.JavaSprintAPI.Mission;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.emanuelxavier.JavaSprintAPI.Player.PlayerModel;
import dev.emanuelxavier.JavaSprintAPI.Player.PlayerDTO;
import dev.emanuelxavier.JavaSprintAPI.Player.PlayerMapper;
import dev.emanuelxavier.JavaSprintAPI.Player.PlayerService;

@Component
public class MissionMapper {

  @Autowired
  private PlayerService playerService;

  @Autowired
  private PlayerMapper playerMapper;

  public MissionModel map(MissionDTO dto) {
    MissionModel mission = new MissionModel();
    mission.setId(dto.getId());
    mission.setName(dto.getName());
    mission.setMinLvl(dto.getMinLvl());

    List<PlayerModel> participants = playerService.findAllById(dto.getParticipants()).stream()
        .map(playerMapper::map)
        .collect(Collectors.toList());

    mission.setParticipants(participants);

    return mission;
  }

  public MissionDTO map(MissionModel model) {
    MissionDTO dto = new MissionDTO();
    dto.setId(model.getId());
    dto.setName(model.getName());
    dto.setMinLvl(model.getMinLvl());

    List<Long> ids = model.getParticipants().stream()
        .map(PlayerModel::getId)
        .toList();
    dto.setParticipants(ids);

    return dto;
  }
}
