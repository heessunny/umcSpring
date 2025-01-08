package umc.spring.service;

import umc.spring.domain.Mission;


import java.util.List;

public interface MissionQueryService {
    List<Mission> findMissionByregion(Long regionId, Long userId);
    Long getMissionCount(Long regionId, Long userId);
}
