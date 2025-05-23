package dev.emanuelxavier.JavaSprintAPI.Mission;

import java.util.List;

import dev.emanuelxavier.JavaSprintAPI.Player.PlayerModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_missions")
public class MissionModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private int min_lvl;

  @OneToMany(mappedBy = "missions")
  private List<PlayerModel> participants;

  public MissionModel() {
  }

  public MissionModel(String name, int min_lvl) {
    this.name = name;
    this.min_lvl = min_lvl;
  }
}
