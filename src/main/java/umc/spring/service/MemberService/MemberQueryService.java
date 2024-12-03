package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.DoMission;

import java.util.List;

public interface MemberQueryService {

    List<Member> findMemberWithId(Long memberId);

    Page<Review> getReviews(Long MemberId, Integer page);
    Page<DoMission> getProgressMission(Long MemberId, Integer page);

}
