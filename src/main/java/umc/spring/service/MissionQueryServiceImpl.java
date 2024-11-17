package umc.spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Optional<DoMission> findDoMission(Long id) {
        return Optional.empty();
    }

    @Override
    public List<DoMission> findDoMissionBymember(Long userId, MissionStatus status) {
        List<DoMission> filteredMissions = missionRepository.findMissionWithMemberIdAndStatus(userId, status);
        filteredMissions.forEach(mission -> System.out.println("progress Mission: " + mission));

        return filteredMissions;
    }


}
