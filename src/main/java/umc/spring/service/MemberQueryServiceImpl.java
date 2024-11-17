package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    @Override
    public List<Member> findMemberWithId(Long memberId) {
        List<Member> filteredMember = memberRepository.findMembersWithId(memberId);

        filteredMember.forEach(member -> System.out.println("Member: " + member));

        return filteredMember;
    }





}
