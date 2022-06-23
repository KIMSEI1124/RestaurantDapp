package com.restaurantdapp.restaurant.domain.embedded.restaurant;

import com.restaurantdapp.restaurant.domain.enumrated.restaurant.Restaurant_tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * <p>레스토랑 상세 주소</p>
 * <p>생성일 : 2022.06.22</p>
 * <p>저자 : KIMSEI</p>
 */
@Getter
@Embeddable
@NoArgsConstructor
public class Restaurant_info {
    /**
     * <p>name : 레스토랑 이름</p>
     * <p>header :  레스토랑 소갯말</p>
     * <p>restaurant_tag : 레스토랑 분류</p>
     * <p>phone_number : 레스토랑 전화번호</p>
     */
    @Column(name = "restaurant_name",
            nullable = false)
    private String name;

    private String header;

    @Enumerated(EnumType.STRING)
    private Restaurant_tag restaurant_tag;

    @Column(name = "restaurant_hours",
            nullable = false)
    private String hours;

    @Column(name = "restaurant_phone_number",
            nullable = false)
    private String phone_number;

    /**
     * 레스토랑 기본 생성자
     * @param name 레스토랑 이름
     * @param header 레스토랑 소갯말
     * @param restaurant_tag 레스토랑 분류
     * @param hours 레스토랑 영업시간
     * @param phone_number 레스토랑 전화번호
     */
    @Builder
    public Restaurant_info(String name, String header, Restaurant_tag restaurant_tag, String hours, String phone_number) {
        this.name = name;
        this.header = header;
        this.restaurant_tag = restaurant_tag;
        this.hours = hours;
        this.phone_number = phone_number;
    }

    /**
     * 레스토랑 소갯말 없는 생성자
     * @param name 레스토랑 이름
     * @param restaurant_tag 레스토랑 분류
     * @param hours 레스토랑 영업시간
     * @param phone_number 레스토랑 전화번호
     */
    @Builder
    public Restaurant_info(String name, Restaurant_tag restaurant_tag, String hours, String phone_number) {
        this.name = name;
        this.restaurant_tag = restaurant_tag;
        this.hours = hours;
        this.phone_number = phone_number;
    }
}
