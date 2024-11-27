package umc.spring.service;

import org.springframework.data.domain.Page;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

public interface DoMissionQueryService {


    DoMission challengeMission(Long id);
     boolean existsByMemberIdAndMissioinId(Long missionId, Long missioinId);
    Page<DoMission> findDoMissionBymember(Long memberId, MissionStatus status);
}
