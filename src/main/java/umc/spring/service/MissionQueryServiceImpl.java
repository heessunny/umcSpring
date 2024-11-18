package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.Mission.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    @Override
    public List<Mission> findMissionByregion(Long regionId, Long userId) {
        List<Mission> filteredMission = missionRepository.findMissionCountByRegionAndUser(regionId,userId);

        filteredMission.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMission;
    }


    @Override
    public Long getMissionCount(Long regionId, Long userId) {
        return missionRepository.countMissionCountByRegionAndUser(regionId, userId);
    }


}
