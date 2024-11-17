package umc.spring.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.DoMission;

public interface MissionRepository extends JpaRepository<DoMission, Long>, MissionRepositoryCustom {
}
