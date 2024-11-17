package umc.spring.service;

import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {

    Optional<DoMission> findDoMission(Long id);

    List<DoMission> findDoMissionBymember(Long memberId, MissionStatus status);
}
