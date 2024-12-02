package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;

import java.util.List;

public interface MemberQueryService {

    List<Member> findMemberWithId(Long memberId);

    Page<Review> getReviews(Long MemberId, Integer page);
}
