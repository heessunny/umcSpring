package umc.spring.service;

import org.springframework.data.domain.Page;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

public interface DoMissionQueryService {


    DoMission challengeMission(Long id);
     boolean existsByMemberIdAndMissioinId(Long missionId, Long missioinId);
     boolean existsProgressByMissionIdAndMemberId(Long missionId, Long memberId);
    Page<DoMission> findDoMissionBymember(Long memberId, MissionStatus status);
    DoMission completeMission(Long MissionId, Long MemberId);
}
