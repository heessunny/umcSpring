package umc.spring.repository.DoMissionRepository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

import java.util.List;

public interface DoMissionRepositoryCustom {
    Page<DoMission> findMissionWithMemberIdAndStatus(Long userId, MissionStatus status,  Pageable pageable);

}
