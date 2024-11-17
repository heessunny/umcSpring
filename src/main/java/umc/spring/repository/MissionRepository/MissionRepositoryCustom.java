package umc.spring.repository.MissionRepository;


import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<DoMission> findMissionWithMemberIdAndStatus(Long userId,MissionStatus status);

}
