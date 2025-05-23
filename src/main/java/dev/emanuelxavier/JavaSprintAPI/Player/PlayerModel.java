package dev.emanuelxavier.JavaSprintAPI.Player;

import java.util.List;

import dev.emanuelxavier.JavaSprintAPI.Mission.MissionModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class PlayerModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;

  private String email;

  private int min_lvl;

  @ManyToOne
  @JoinColumn(name = "missions_id")
  private MissionModel mission;

  public PlayerModel() {
  }

  public PlayerModel(String username, String email, int min_lvl, long id) {
    this.username = username;
    this.email = email;
    this.min_lvl = min_lvl;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getMin_lvl() {
    return min_lvl;
  }

  public void setMin_lvl(int min_lvl) {
    this.min_lvl = min_lvl;
  }

  public MissionModel getMission() {
    return mission;
  }

  public void setMission(MissionModel mission) {
    this.mission = mission;
  }

}
