package umc.spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;
import umc.spring.repository.DoMissionRepository.DoMissionRepository;
import umc.spring.repository.Mission.MissionRepository;
import umc.spring.repository.memberRepository.MemberRepository;



@Service
@RequiredArgsConstructor
public class DoMissionQueryServiceImpl implements DoMissionQueryService {

    private final DoMissionRepository doMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;


    int pageNumber = 0; // 첫 번째 페이지
    int pageSize = 10; // 한 페이지에 10개의 항목
    Pageable pageable = PageRequest.of(pageNumber, pageSize);


    @Override
    public DoMission challengeMission(Long mission_id) {

        Mission mission = missionRepository.findById(mission_id)
                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.MISSION_NOT_FOUND));  // missionId로 Mission 존재 확인

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND));


        DoMission newDoMission = new DoMission(MissionStatus.PROGRESS, member, mission);
        doMissionRepository.save(newDoMission);

        return newDoMission;
    }

    @Override
    public boolean existsByMemberIdAndMissioinId(Long missionId, Long memberId) {
        return doMissionRepository.existsByMissionIdAndMemberId(missionId,memberId);

    }

    @Override
    public boolean existsProgressByMissionIdAndMemberId(Long missionId,Long memberId) {
        return doMissionRepository.existsByMissionIdAndMemberIdAndStatus(missionId,memberId,MissionStatus.PROGRESS);
    }


    @Override
    public Page<DoMission> findDoMissionBymember(Long userId, MissionStatus status) {
        Page<DoMission> filteredMissions = doMissionRepository.findMissionWithMemberIdAndStatus(userId, status,pageable);
        filteredMissions.forEach(mission -> System.out.println("progress Mission: " + mission));

        return filteredMissions;
    }

    @Override
    public DoMission completeMission(Long MissionId, Long MemberId) {

        System.out.println("MissionId: " + MissionId + ", MemberId: " + MemberId);

        DoMission progressMission = doMissionRepository.findByMissionIdAndMemberId(MissionId, MemberId).get();

        progressMission.setStatus(MissionStatus.COMPLETE);
        doMissionRepository.save(progressMission);

        return progressMission;
    }


}
