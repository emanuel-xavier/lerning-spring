package dev.emanuelxavier.JavaSprintAPI.Mission;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {

  private MissionRepository missionRepository;
  private MissionMapper missionMapper;

  public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
    this.missionRepository = missionRepository;
    this.missionMapper = missionMapper;
  }

  public List<MissionDTO> list() {
    List<MissionModel> missions = missionRepository.findAll();
    return missions.stream()
        .map(missionMapper::map)
        .collect(Collectors.toList());
  }

  public MissionDTO findByID(long id) {
    Optional<MissionModel> mission = missionRepository.findById(id);
    return mission.map(missionMapper::map).orElse(null);
  }

  public List<MissionDTO> findAllByID(List<Long> ids) {
    List<MissionModel> missions = missionRepository.findAllById(ids);
    return missions.stream()
        .map(missionMapper::map)
        .collect(Collectors.toList());
  }

  public MissionDTO create(MissionDTO missionDTO) {
    MissionModel mission = missionMapper.map(missionDTO);
    mission = missionRepository.save(mission);
    return missionMapper.map(mission);
  }

  public void deleteById(long id) {
    missionRepository.deleteById(id);
  }

  public MissionDTO update(Long id, MissionDTO missionDTO) {
    Optional<MissionModel> mission = missionRepository.findById(id);
    if (!mission.isPresent()) {
      return null;
    }

    MissionModel updatedMission = missionMapper.map(missionDTO);
    updatedMission.setId(id);
    updatedMission = missionRepository.save(updatedMission);

    return missionMapper.map(updatedMission);
  }
}
