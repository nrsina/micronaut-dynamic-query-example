package com.snourian.example.dynquery.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Location {

    @Column(nullable = false)
    private int district;

    @Column(nullable = false)
    private String city;

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return district == location.district && city.equals(location.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(district, city);
    }
}
