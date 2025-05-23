package dev.emanuelxavier.JavaSprintAPI.Mission;

import java.util.List;

import dev.emanuelxavier.JavaSprintAPI.Player.PlayerModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_missions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissionModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "min_lvl")
  private int min_lvl;

  @OneToMany(mappedBy = "missions")
  private List<PlayerModel> participants;
}
