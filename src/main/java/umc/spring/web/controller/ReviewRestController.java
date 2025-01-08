package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{store_id}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> reviewCommandService(@PathVariable("store_id") @ExistStore Long storeId, @RequestBody @Valid ReviewRequestDTO.CreateReviewDto request){

        Review review = reviewCommandService.registerReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }
}
