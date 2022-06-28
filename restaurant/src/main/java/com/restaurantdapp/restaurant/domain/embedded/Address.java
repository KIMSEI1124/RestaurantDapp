package com.restaurantdapp.restaurant.domain.embedded;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <p>주소</p>
 * <p>생성일 : 2022.06.22</p>
 * <p>저자 : KIMSEI</p>
 */
@Getter
@Embeddable
@NoArgsConstructor
public class Address {
    /**
     * <p>address : 주소</p>
     * <p>address_info : 상세주소</p>
     * <p>longitude : 경도</p>
     * <p>latitude : 위도</p>
     */
    private String address;
    private String address_info;
    private double latitude;
    private double longitude;

    /**
     * <p>상세 주소 있는 주소</p>
     * @param address 주소
     * @param address_info 상세주소
     * @param longitude 경도
     * @param latitude 위도
     */
    @Builder
    public Address(String address, String address_info, double longitude, double latitude) {
        this.address = address;
        this.address_info = address_info;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * <p>상세 주소 없는 주소</p>
     *
     * @param address 주소
     * @param longitude 경도
     * @param latitude 위도
     */
    @Builder
    public Address(String address, double longitude, double latitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }


}
