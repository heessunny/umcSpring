package umc.spring.repository.DoMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.DoMission;

public interface DoMissionRepository extends JpaRepository<DoMission, Long>, DoMissionRepositoryCustom {
}
