package umc.spring.service;

import umc.spring.repository.ReviewRepository.ReviewRepository;

public interface ReviewQueryService {


    void  createReview(Long userId, Long storeId, float score, String content);
}
