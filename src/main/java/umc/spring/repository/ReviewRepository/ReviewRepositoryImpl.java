package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;

    @Override
    public void createReview(Long userId, Long storeId, float score, String content) {
        Member member = entityManager.getReference(Member.class, userId);
        Store store = entityManager.getReference(Store.class, storeId);

        Review review = Review.builder()
                .member(member)
                .store(store)
                .content(content)
                .score(score)
                .build();

        entityManager.persist(review);
    }

}
