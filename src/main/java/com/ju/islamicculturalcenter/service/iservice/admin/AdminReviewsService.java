package com.ju.islamicculturalcenter.service.iservice.admin;

import com.ju.islamicculturalcenter.dto.response.ResponseList;
import com.ju.islamicculturalcenter.dto.response.student.review.ReviewResponse;

public interface AdminReviewsService {

    ResponseList<ReviewResponse> findAllReviews(Long courseId, Long instructorId, Integer page, Integer size);
}
