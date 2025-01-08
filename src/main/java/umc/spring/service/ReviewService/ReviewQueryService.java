package umc.spring.service.ReviewService;

public interface ReviewQueryService {

    void  createReview(Long userId, Long storeId, float score, String content);
}
