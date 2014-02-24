package tcw.domain.v1;

import java.io.Serializable;

public class AddressV1 implements Serializable{

    private static final long serialVersionUID = 1L;

    private int homeNo;
    private String street;
    private String city;

    public int getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(int homeNo) {
        this.homeNo = homeNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressExtV1{" +
                "homeNo=" + homeNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
