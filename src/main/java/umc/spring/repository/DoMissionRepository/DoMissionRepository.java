package umc.spring.repository.DoMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

public interface DoMissionRepository extends JpaRepository<DoMission, Long>, DoMissionRepositoryCustom {
    boolean existsByMissionIdAndMemberId(Long missionId, Long memberId);
    Page<DoMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);
}
