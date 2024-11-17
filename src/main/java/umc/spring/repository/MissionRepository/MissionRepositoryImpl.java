package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;
import umc.spring.domain.mapping.QDoMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QDoMission doMission = QDoMission.doMission;

    @Override
    public List<DoMission> findMissionWithMemberIdAndStatus(Long userId, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(doMission.member.id.eq(userId));
        }

        if (status != null) {
            predicate.and(doMission.status.eq(status));
        }

        return jpaQueryFactory
                .selectFrom(doMission)
                .where(predicate)
                .fetch();
    }
}