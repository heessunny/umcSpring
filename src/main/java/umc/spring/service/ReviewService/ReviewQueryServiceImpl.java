package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class ReviewQueryServiceImpl  implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public void createReview(Long userId, Long storeId, float score, String content)  {
        reviewRepository.createReview(userId,storeId,score,content);

    }
}
