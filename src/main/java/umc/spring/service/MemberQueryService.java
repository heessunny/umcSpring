package umc.spring.service;

import umc.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);


}
