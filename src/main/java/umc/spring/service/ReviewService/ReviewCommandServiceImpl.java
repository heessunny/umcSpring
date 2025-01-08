package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review registerReview(Long id, ReviewRequestDTO.CreateReviewDto request) {

        Review newReview = ReviewConverter.toReview(request);


        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
                newReview.setStore(store);

        return reviewRepository.save(newReview);
    }
}
