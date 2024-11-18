package umc.spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;
import umc.spring.repository.DoMissionRepository.DoMissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DoMissionQueryServiceImpl implements DoMissionQueryService {

    private final DoMissionRepository missionRepository;

    int pageNumber = 0; // 첫 번째 페이지
    int pageSize = 10; // 한 페이지에 10개의 항목
    Pageable pageable = PageRequest.of(pageNumber, pageSize);

    @Override
    public Optional<DoMission> findDoMission(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<DoMission> findDoMissionBymember(Long userId, MissionStatus status) {
        Page<DoMission> filteredMissions = missionRepository.findMissionWithMemberIdAndStatus(userId, status,pageable);
        filteredMissions.forEach(mission -> System.out.println("progress Mission: " + mission));

        return filteredMissions;
    }


}
