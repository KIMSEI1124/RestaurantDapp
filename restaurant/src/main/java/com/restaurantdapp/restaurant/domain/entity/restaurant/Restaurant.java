package com.restaurantdapp.restaurant.domain.entity.restaurant;


import com.restaurantdapp.restaurant.domain.embedded.Address;
import com.restaurantdapp.restaurant.domain.embedded.restaurant.Restaurant_info;
import com.restaurantdapp.restaurant.domain.enumrated.Country;
import com.restaurantdapp.restaurant.domain.enumrated.restaurant.Restaurant_tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <p>레스토랑 엔티티</p>
 * <p>생성일 : 2022.06.22</p>
 * <p>저자 : KIMSEI</p>
 */
@Entity
@Getter
@NoArgsConstructor
public class Restaurant {
    /**
     * <p>restaurant_id : 레스토랑 Index</p>
     * <p>country : 해당 레스토랑의 국적</p>
     * <p>restaurant_info : 레스토랑 정보</p>
     * <p>restaurant_address : 레스토랑 주소</p>
     */
    @Id
    @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Embedded
    private Restaurant_info restaurant_info;

    @Embedded
    private Address restaurant_address;

    @Builder
    public Restaurant(Country country, Restaurant_info restaurant_info, Address restaurant_address) {
        this.country = country;
        this.restaurant_info = restaurant_info;
        this.restaurant_address = restaurant_address;
    }
}
