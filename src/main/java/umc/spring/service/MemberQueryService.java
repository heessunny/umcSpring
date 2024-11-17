package umc.spring.service;

import umc.spring.domain.Member;
import umc.spring.domain.Store;


import java.util.List;
import java.util.Optional;

public interface MemberQueryService {


    List<Member> findMemberWithId(Long memberId);

}
