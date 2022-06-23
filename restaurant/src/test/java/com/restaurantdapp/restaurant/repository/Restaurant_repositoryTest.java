package com.restaurantdapp.restaurant.repository;

import com.restaurantdapp.restaurant.domain.embedded.Address;
import com.restaurantdapp.restaurant.domain.embedded.restaurant.Restaurant_info;
import com.restaurantdapp.restaurant.domain.entity.restaurant.Restaurant;
import com.restaurantdapp.restaurant.domain.enumrated.Country;
import com.restaurantdapp.restaurant.domain.enumrated.restaurant.Restaurant_tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;


/**
 * <p>Restaurant_repository 테스트</p>
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class Restaurant_repositoryTest {
    @Autowired
    Restaurant_repository restaurant_repository;

    /**
     * <p>1개의 레스토랑 설정</p>
     * @return 1개의 저장된 레스토랑
     */
    public Restaurant settingRestaurantByOne() {
        Restaurant_info restaurant_info = Restaurant_info.builder()
                .name("중화미식")
                .header("주문 즉시 조리가 이루어지는 불맛나는 고기짬뽕이 일품인 중화미식입니다. 모든 메뉴는 포장 가능합니다.")
                .restaurant_tag(Restaurant_tag.중식당)
                .hours("임의")
                .phone_number("031-468-6888")
                .build();

        Address address = Address.builder()
                .address("경기 안양시 만안구 양화로 4")
                .latitude(37.3945373)
                .longitude(126.9159423)
                .build();


        return Restaurant.builder()
                .country(Country.KOR)
                .restaurant_info(restaurant_info)
                .restaurant_address(address)
                .build();
    }

    /**
     * <p>레스토랑 저장</p>
     */
    @Test
    @Transactional
    public void restaurantSave() {
        // given
        Restaurant restaurant = settingRestaurantByOne();

        // when
        Long restaurant_id = restaurant_repository.save(restaurant);

        // then
        Assertions.assertEquals(restaurant.getId(), restaurant_id, "두개의 값이 동일해야 합니다..");
    }

    /**
     * 레스토랑 id로 검색
     */
    @Test
    @Transactional
    public void findByIdRestaurant() {
        // given
        Restaurant restaurant = settingRestaurantByOne();

        // when
        Long restaurant_id = restaurant_repository.save(restaurant);
        Restaurant byIdRestaurant = restaurant_repository.findById(restaurant_id);

        // then
        Assertions.assertEquals(restaurant_id, byIdRestaurant.getId(), "두개의 값이 동일해야 합니다.");
    }
}