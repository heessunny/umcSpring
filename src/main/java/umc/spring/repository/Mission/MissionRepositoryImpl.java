package umc.spring.repository.Mission;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QDoMission;



import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QDoMission doMission = QDoMission.doMission;
    private final QMember member = QMember.member;
    private final QRegion region = QRegion.region;

    @Override
    public List<Mission> findMissionCountByRegionAndUser(Long regionId, Long userId) {
        BooleanBuilder predicate = new BooleanBuilder();


        if (regionId != null) {
            predicate.and(store.region.id.eq(regionId));
        }


        if (userId != null) {
            predicate.and(member.id.eq(userId));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                        store.region.id.eq(regionId)
                                .and(
                                        JPAExpressions.selectOne()
                                                .from(doMission)
                                                .join(doMission.member, member)
                                                .where(
                                                        doMission.mission.id.eq(mission.id)
                                                                .and(member.id.eq(userId))
                                                )
                                                .notExists()
                                )
                )
                .fetch();

    }

    @Override
    public Long countMissionCountByRegionAndUser(Long regionId, Long userId) {

            BooleanBuilder predicate = new BooleanBuilder();

            if (regionId != null) {
                predicate.and(store.region.id.eq(regionId));
            }

            if (userId != null) {
                predicate.and(member.id.eq(userId));
            }

            predicate.and(doMission.status.eq(MissionStatus.COMPLETE));

            return jpaQueryFactory
                    .select(mission.id.count())
                    .from(mission)
                    .join(mission.store, store)
                    .join(store.region, region)
                    .join(mission.doMissionList, doMission)
                    .join(doMission.member, member)
                    .where(predicate)
                    .fetchOne();  // count 값만 반환하므로 fetchOne() 사용
        }

}

