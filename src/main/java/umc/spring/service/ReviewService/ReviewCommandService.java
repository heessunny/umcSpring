package umc.spring.service.ReviewService;

import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

import java.util.Optional;

public interface ReviewCommandService {

    Review registerReview(Long id, ReviewRequestDTO.CreateReviewDto request);


}
