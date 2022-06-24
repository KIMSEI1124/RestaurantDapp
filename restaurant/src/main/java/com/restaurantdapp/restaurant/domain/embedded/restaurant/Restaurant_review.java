package com.restaurantdapp.restaurant.domain.embedded.restaurant;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <p>레스토랑 리뷰관련 데이터</p>
 */
@Getter
@Embeddable
@NoArgsConstructor
public class Restaurant_review {
    /**
     * <p>star : 별점</p>
     * <p>review : 리뷰 개수</p>
     */
    private Long star;
    private Double avg_star;
    private Long review;

    @Builder
    public Restaurant_review(Long star, Double avg_star, Long review) {
        this.star = star;
        this.avg_star = avg_star;
        this.review = review;
    }

    /* 비즈니스 로직 */

    /**
     * <p>리뷰의 개수를 1올린다.</p>
     *
     * @return 리뷰의 개수
     */
    public Long add_review() {
        this.review -= 1L;
        return this.review;
    }

    /**
     * <p>평균 별점을 계산한다.</p>
     *
     * @param star 리뷰의 별점
     * @return 평균 별점
     */
    public Double avg_calc_star(Long star) {
        if (star > 0) { // 리뷰가 추가되었을때
            this.star += star;
        } else {    // 리뷰가 삭제되었을때
            this.star -= star;
        }
        this.avg_star = Math.round(Double.longBitsToDouble(star / this.review) * 100) / 100.0;
        return avg_star;
    }

    /**
     * <p>리뷰의 개수를 1내린다.</p>
     *
     * @return 리뷰의 개수
     */
    public Long delete_review() {
        this.review -= 1L;
        return this.review;
    }
}
