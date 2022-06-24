package com.restaurantdapp.restaurant.domain.entity.restaurant;


import com.restaurantdapp.restaurant.domain.embedded.Address;
import com.restaurantdapp.restaurant.domain.embedded.restaurant.Restaurant_info;
import com.restaurantdapp.restaurant.domain.embedded.restaurant.Restaurant_review;
import com.restaurantdapp.restaurant.domain.enumrated.Country;
import com.restaurantdapp.restaurant.domain.enumrated.restaurant.Restaurant_tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <p>레스토랑 엔티티</p>
 */
@Entity
@Getter
@NoArgsConstructor
public class Restaurant {
    /**
     * <p>restaurant_id : 레스토랑 Index</p>
     * <p>country : 해당 레스토랑의 국적</p>
     * <p>restaurant_address : 레스토랑 주소</p>
     * <p>restaurant_info : 레스토랑 정보</p>
     * <p>restaurant_review : 레스토랑 리뷰관련정보</p>
     */
    @Id
    @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Embedded
    private Address restaurant_address;

    @Embedded
    private Restaurant_info restaurant_info;

    @Embedded
    private Restaurant_review restaurant_review_info;

    @Builder
    public Restaurant(Country country, Address restaurant_address, Restaurant_info restaurant_info, Restaurant_review restaurant_review_info) {
        this.country = country;
        this.restaurant_address = restaurant_address;
        this.restaurant_info = restaurant_info;
        this.restaurant_review_info = restaurant_review_info;
    }
}
