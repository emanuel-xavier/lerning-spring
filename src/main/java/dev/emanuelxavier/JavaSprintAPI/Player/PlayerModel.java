package dev.emanuelxavier.JavaSprintAPI.Player;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.emanuelxavier.JavaSprintAPI.Mission.MissionModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "lvl")
  private int lvl;

  @ManyToOne
  @JoinColumn(name = "missions_id", nullable = true)
  @JsonIgnore
  private MissionModel mission;

  @Column(name = "rank")
  private String rank;
}
