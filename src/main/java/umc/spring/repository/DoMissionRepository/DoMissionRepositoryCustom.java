package umc.spring.repository.DoMissionRepository;


import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

import java.util.List;

public interface DoMissionRepositoryCustom {
    List<DoMission> findMissionWithMemberIdAndStatus(Long userId,MissionStatus status);

}
