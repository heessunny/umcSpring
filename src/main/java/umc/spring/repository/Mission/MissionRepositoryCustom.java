package umc.spring.repository.Mission;


import umc.spring.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {

    List<Mission> findMissionCountByRegionAndUser(Long regionId, Long userId);
    Long countMissionCountByRegionAndUser(Long regionId, Long userId);

}
