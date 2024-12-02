package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.memberRepository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    @Override
    public List<Member> findMemberWithId(Long memberId) {
        List<Member> filteredMember = memberRepository.findMembersWithId(memberId);

        filteredMember.forEach(member -> System.out.println("Member: " + member));

        return filteredMember;
    }
    @Override
    public Page<Review> getReviews(Long MemberId, Integer page) {
        Member member = memberRepository.findById(MemberId).get();

        Page<Review> MemberPage = reviewRepository.findAllByMember(member, PageRequest.of(page,10));
        return MemberPage;
    }
}
