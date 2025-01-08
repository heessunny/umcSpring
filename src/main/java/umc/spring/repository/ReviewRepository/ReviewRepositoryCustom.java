package umc.spring.repository.ReviewRepository;

import umc.spring.domain.Review;

public interface ReviewRepositoryCustom {


    void createReview(Long userId, Long storeId, float score, String content);
}
