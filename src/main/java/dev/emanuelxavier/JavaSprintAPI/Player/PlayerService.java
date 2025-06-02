package dev.emanuelxavier.JavaSprintAPI.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

  private PlayerRepository playerRepository;
  private PlayerMapper playerMapper;

  @Autowired
  public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
    this.playerRepository = playerRepository;
    this.playerMapper = playerMapper;
  }

  public List<PlayerDTO> list() {
    List<PlayerModel> players = playerRepository.findAll();
    return players.stream()
        .map(playerMapper::map)
        .collect(Collectors.toList());
  }

  public PlayerDTO findByID(long id) {
    Optional<PlayerModel> player = playerRepository.findById(id);
    return player.map(playerMapper::map).orElse(null);
  }

  public PlayerDTO create(PlayerDTO playerDTO) {
    PlayerModel player = playerMapper.map(playerDTO);
    player = playerRepository.save(player);
    return playerMapper.map(player);
  }

  public void deleteById(long id) {
    playerRepository.deleteById(id);
  }

  public PlayerDTO update(Long id, PlayerDTO playerDTO) {
    Optional<PlayerModel> player = playerRepository.findById(id);
    if (!player.isPresent()) {
      return null;
    }

    PlayerModel updatedPlayer = playerMapper.map(playerDTO);
    updatedPlayer.setId(id);
    updatedPlayer = playerRepository.save(updatedPlayer);

    return playerMapper.map(updatedPlayer);
  }

  public List<PlayerDTO> findAllById(List<Long> ids) {
    List<PlayerModel> players = playerRepository.findAllById(ids);
    return players.stream()
        .map(playerMapper::map)
        .collect(Collectors.toList());
  }
}
