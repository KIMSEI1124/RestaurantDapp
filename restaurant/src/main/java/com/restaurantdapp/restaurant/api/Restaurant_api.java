package com.restaurantdapp.restaurant.api;

import com.restaurantdapp.restaurant.domain.embedded.Address;
import com.restaurantdapp.restaurant.domain.embedded.restaurant.Restaurant_info;
import com.restaurantdapp.restaurant.domain.embedded.restaurant.Restaurant_review;
import com.restaurantdapp.restaurant.domain.entity.restaurant.Restaurant;
import com.restaurantdapp.restaurant.domain.enumrated.Country;
import com.restaurantdapp.restaurant.domain.enumrated.restaurant.Restaurant_tag;
import com.restaurantdapp.restaurant.service.Restaurant_service;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class Restaurant_api {
    private final Restaurant_service restaurant_service;

    @PostMapping("/api/restaurant/save")
    public save_response restaurant_save(@RequestBody @Valid save_request request
            , save_address_request address_request
            , save_restaurant_info_request info_request) {
        Address address = Address.builder()
                .address(address_request.getAddress())
                .address_info(address_request.getAddress_info())
                .latitude(address_request.getLatitude())
                .longitude(address_request.getLongitude())
                .build();

        Restaurant_info info = Restaurant_info.builder()
                .name(info_request.getName())
                .header(info_request.getHeader())
                .restaurant_tag(info_request.getTag())
                .hours(info_request.getHours())
                .phone_number(info_request.getPhone_number())
                .build();

        Restaurant_review review = Restaurant_review.builder()
                .star(0L)
                .avg_star(0D)
                .review(0L)
                .build();

        Restaurant restaurant = Restaurant.builder()
                .country(request.getCountry())
                .restaurant_address(address)
                .restaurant_info(info)
                .restaurant_review_info(review)
                .build();
        Long save_id = restaurant_service.save(restaurant);
        return new save_response(save_id);
    }

    @Data
    static class save_request {
        @NotEmpty
        private Country country;
        private Address address;
        private Restaurant_info info;
        private Restaurant_review review_info;
    }

    @Data
    static class save_address_request {
        @NotEmpty
        private String address;
        private String address_info;
        @NotEmpty
        private double latitude;
        @NotEmpty
        private double longitude;
    }

    @Data
    static class save_restaurant_info_request {
        @NotEmpty
        private String name;
        private String header;
        @NotEmpty
        private Restaurant_tag tag;
        @NotEmpty
        private String hours;
        @NotEmpty
        private String phone_number;
    }

    @Data
    static class save_response {
        private Long id;

        public save_response(Long id) {
            this.id = id;
        }
    }
}