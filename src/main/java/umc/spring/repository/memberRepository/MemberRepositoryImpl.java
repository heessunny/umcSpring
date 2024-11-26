package umc.spring.repository.memberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;


    public List<Member> findMembersWithId(Long id) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (id != null) {
            predicate.and(member.id.eq(id));
        }

        return jpaQueryFactory
                .selectFrom(member)
                .where(predicate)
                .fetch();
    }


}
