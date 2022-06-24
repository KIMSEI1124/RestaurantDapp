package com.restaurantdapp.restaurant.repository;

import com.restaurantdapp.restaurant.domain.entity.restaurant.Restaurant;
import com.restaurantdapp.restaurant.domain.enumrated.Country;
import com.restaurantdapp.restaurant.domain.enumrated.restaurant.Restaurant_tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * <p>추후 QueryDSL 변환예정</p>
 */
@Repository
@RequiredArgsConstructor
public class Restaurant_repository {
    private final EntityManager em;

    /**
     * <p>레스트랑을 저장한다.</p>
     *
     * @param restaurant 레스토랑
     * @return 레스토랑 Id
     */
    public Long save(Restaurant restaurant) {
        em.persist(restaurant);
        return restaurant.getId();
    }

    /**
     * <p>미완성</p>
     * <p>레스토랑을 삭제한다.</p>
     * @param id    레스토랑 Id
     */
    public void deleteById(Long id) {
        em.createQuery("delete from Restaurant where id =: id")
                .setParameter("id", id);
    }

    /**
     * <p>레스토랑 Id로 레스토랑을 검색한다.</p>
     *
     * @param id 레스토랑 Id
     * @return 해당 레스토랑
     */
    public Restaurant findById(Long id) {
        return em.find(Restaurant.class, id);
    }

    /**
     * <p>전체 레스토랑을 검색한다.</p>
     *
     * @return 전체 레스토랑
     */
    public List<Restaurant> findAll() {
        return em.createQuery("select r from Restaurant as r", Restaurant.class)
                .getResultList();
    }

    /**
     * <p>해당 국가의 레스토랑을 검색한다.</p>
     *
     * @param country 국가
     * @return 해당 국가의 레스토랑
     */
    public List<Restaurant> findByCountry(Country country) {
        return em.createQuery("select r from Restaurant as r where r.country =: country", Restaurant.class)
                .setParameter("country", country)
                .getResultList();
    }

    /**
     * <p>해당 국가와 태그에 맞는 레스토랑을 검색한다.</p>
     * <p>미완성</p>
     *
     * @param country 국가
     * @param tag     레스토랑 분류
     * @return 해당 국가와 태그의 레스토랑
     */
    public List<Restaurant> findByCountryByTag(Country country, Restaurant_tag tag) {
        String query = "";
        return em.createQuery(query, Restaurant.class)
                .getResultList();
    }

    /**
     * <p>해당 국가와 이름에 맞는 레스토랑을 검색한다.</p>
     * <p>미완성</p>
     *
     * @param country 국가
     * @param name    레스토랑 이름
     * @return 해당 국가와 이름을 가진 레스토랑
     */
    public List<Restaurant> findByCountryByName(Country country, String name) {
        String query = "";
        return em.createQuery(query, Restaurant.class)
                .getResultList();
    }
}
