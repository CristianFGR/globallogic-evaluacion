package com.globallogic.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by cristianfgr on 12-02-20.
 */
@Entity
@Table(name = "phones")
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @JsonProperty("citycode")
    private String cityCode;

    @JsonProperty("countrycode")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "fk_id_usercontact")
    private UserContact userContac;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "number='" + number + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
