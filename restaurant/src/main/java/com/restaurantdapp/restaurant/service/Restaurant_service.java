package com.restaurantdapp.restaurant.service;

import com.restaurantdapp.restaurant.domain.entity.restaurant.Restaurant;
import com.restaurantdapp.restaurant.domain.enumrated.Country;
import com.restaurantdapp.restaurant.domain.enumrated.restaurant.Restaurant_tag;
import com.restaurantdapp.restaurant.repository.Restaurant_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Restaurant_service {
    final private Restaurant_repository restaurant_repository;

    /* 저장 */
    /**
     * <p>레스토랑을 저장한다</p>
     * @param restaurant    레스토랑
     * @return  레스토랑 Id
     */
    @Transactional
    public Long save(Restaurant restaurant) {
        restaurant_repository.save(restaurant);
        return restaurant.getId();
    }

    /* 검색 */
    /**
     * <p>레스토랑을 Id로 검색한다.</p>
     * @param id    레스토랑 Id
     * @return  레스토랑
     */
    public Restaurant findByIdRestaurant(Long id) {
        return restaurant_repository.findById(id);
    }

    /**
     * <p>레스토랑 전체를 조회한다.</p>
     * @return  전체 레스토랑
     */
    public List<Restaurant> findRestaurant() {
        return restaurant_repository.findAll();
    }

    /**
     * <p>해당 국가에 포함되는 레스토랑을 조회한다.</p>
     * @param country   국가
     * @return  해당 국가에 포함되는 레스토랑
     */
    public List<Restaurant> findByCountryRestaurant(Country country) {
        return restaurant_repository.findByCountry(country);
    }

    /**
     * <p>해당 국가에 포함되고 분류에 맞는 레스토랑을 조회한다.</p>
     * <p>미완성</p>
     * @param country   국가
     * @param tag   레스토랑 분류
     * @return  조건에 맞는 레스토랑
     */
    public List<Restaurant> findByCountryByTagRestaurant(Country country, Restaurant_tag tag) {
        return restaurant_repository.findByCountryByTag(country, tag);
    }

    /**
     * <p>해당 국가에 포함되고 이름과 동일한 레스토랑을 조회한다.</p>
     * <p>미완성</p>
     * @param country   국가
     * @param name  이름
     * @return  조건에 맞는 레스토랑
     */
    public List<Restaurant> findByCountryByName(Country country, String name) {
        return restaurant_repository.findByCountryByName(country, name);
    }

    /* 비즈니스 로직 */
    public void add_review() {

    }
}
