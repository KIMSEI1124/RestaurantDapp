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

import java.util.ArrayList;
import java.util.List;


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
     *
     * @return 1개의 저장된 레스토랑
     */
    public Restaurant settingRestaurant_중화미식() {
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

    public Restaurant settingRestaurant_역전우동() {
        Restaurant_info restaurant_info = Restaurant_info.builder()
                .name("역전우동0410 안양일번가점")
                .header("역전우동0410은 가쓰오부시의 감칠맛으로 대표되는 일본식 우동 국물 맛 속에서도 한국식 가락국수 특유의 개운한 맛을 느낄 수 있는 지점, 우리의 보편적 입맛을 사로잡을 한국식 우동 맛을 찾아내려 끊임없이 연구하였습니다.\n" +
                        "\n" +
                        "차분하고 단정하게 면의 씹는 맛을 살리면서도, 한편으로는 입에 착 감기는 감칠맛으로 긴 여운을 남기는 깊은 맛의 우동.. 오늘날 우리 입맛에 맞는 독자적 메뉴를 개발하는 것에 큰 가치를 두고 있으며, 한국식 우동의 역사를 새로 써 내려가고 있습니다.\n" +
                        "\n" +
                        "편안한 공간에서 부담없이, 맛있는 우동과 함께 옛날 기차역 앞에서의 추억을 찾아 보세요!")
                .restaurant_tag(Restaurant_tag.우동)
                .hours("임의")
                .phone_number("031-465-0410")
                .build();

        Address address = Address.builder()
                .address("경기 안양시 만안구 장내로139번길 28 1층")
                .latitude(37.3989096)
                .longitude(126.922376)
                .build();


        return Restaurant.builder()
                .country(Country.KOR)
                .restaurant_info(restaurant_info)
                .restaurant_address(address)
                .build();
    }

    /**
     * 여러개의 레스토랑 설정
     *
     * @return 여러개 저장된 레스토랑
     */
    public List<Restaurant> settingRestaurantByMany() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(settingRestaurant_중화미식());
        restaurants.add(settingRestaurant_역전우동());
        return restaurants;
    }

    /**
     * <p>1. 레스토랑 저장</p>
     * <p>2. 레스토랑 id로 검색</p>
     */
    @Test
    @Transactional
    public void restaurantSave() {
        // given
        Restaurant restaurant = settingRestaurant_역전우동();

        // when
        Long restaurant_id = restaurant_repository.save(restaurant);
        Restaurant byIdRestaurant = restaurant_repository.findById(restaurant_id);

        // then
        Assertions.assertEquals(restaurant.getId(), restaurant_id, "두개의 값이 동일해야 합니다.");
        Assertions.assertEquals(restaurant_id, byIdRestaurant.getId(), "두개의 값이 동일해야 합니다.");
    }

    /**
     * <p>미완성 - persist 에서 오류 발생</p>
     * <p>1. 레스토랑들 저장</p>
     * <p>2. 레스토랑들 id로 검색</p>
     */
    @Test
    public void restaurantsSave() {
        // given
        List<Restaurant> restaurants = settingRestaurantByMany();
        List<Restaurant> find_restaurants = new ArrayList<>();
        List<Long> index = new ArrayList<>();

        // when
        for (Restaurant restaurant : restaurants) {
            Long restaurant_id = restaurant_repository.save(restaurant);
            find_restaurants.add(restaurant_repository.findById(restaurant_id));
            index.add(restaurant_id);
        }

        // then
        for (int i = 0; i < index.size(); i++) {
            Assertions.assertEquals(restaurants.get(i).getId(), index.get(i), "두개의 값이 동일해야 합니다.");
            Assertions.assertEquals(restaurants.get(i).getId(), find_restaurants.get(i).getId(), "두개의 값이 동일해야 합니다.");
        }
    }
}