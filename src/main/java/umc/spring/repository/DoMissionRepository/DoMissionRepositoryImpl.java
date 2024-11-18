package umc.spring.repository.DoMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;
import umc.spring.domain.mapping.QDoMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoMissionRepositoryImpl implements DoMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QDoMission doMission = QDoMission.doMission;

    @Override

    public Page<DoMission> findMissionWithMemberIdAndStatus(Long userId, MissionStatus status, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(doMission.member.id.eq(userId));
        }

        if (status != null) {
            predicate.and(doMission.status.eq(status));
        }

        QueryResults<DoMission> results = jpaQueryFactory
                .selectFrom(doMission)
                .where(predicate)
                .offset(pageable.getOffset()) // 페이지 오프셋 설정
                .limit(pageable.getPageSize()) // 페이지 크기 설정
                .fetchResults(); // 결과를 페이징 처리하여 가져옴

        List<DoMission> content = results.getResults(); // 실제 데이터
        long total = results.getTotal(); // 전체 데이터 수

        return new PageImpl<>(content, pageable, total); // Page 객체로 반환
    }
}