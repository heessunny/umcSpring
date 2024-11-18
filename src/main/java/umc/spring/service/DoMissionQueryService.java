package umc.spring.service;

import org.springframework.data.domain.Page;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

import java.util.List;
import java.util.Optional;

public interface DoMissionQueryService {

    Optional<DoMission> findDoMission(Long id);

    Page<DoMission> findDoMissionBymember(Long memberId, MissionStatus status);
}
