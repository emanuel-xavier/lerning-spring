package dev.emanuelxavier.JavaSprintAPI.Player;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

  private PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public List<PlayerModel> list() {
    return playerRepository.findAll();
  }

}
