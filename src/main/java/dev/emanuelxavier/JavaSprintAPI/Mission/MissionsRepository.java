package dev.emanuelxavier.JavaSprintAPI.Mission;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionsRepository extends JpaRepository<MissionModel, Long> {

}
