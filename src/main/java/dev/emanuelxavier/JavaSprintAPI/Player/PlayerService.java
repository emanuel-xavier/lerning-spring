package dev.emanuelxavier.JavaSprintAPI.Player;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

  private PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public List<PlayerModel> list() {
    return playerRepository.findAll();
  }

  public PlayerModel findByID(long id) {
    Optional<PlayerModel> player = playerRepository.findById(id);
    return player.orElse(null);
  }

  public PlayerModel create(PlayerModel player) {
    return playerRepository.save(player);
  }

  public void deleteById(long id) {
    playerRepository.deleteById(id);
  }

}
