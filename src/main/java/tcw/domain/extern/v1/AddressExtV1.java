package tcw.domain.extern.v1;

import java.io.*;

public class AddressExtV1 implements Externalizable{

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

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(homeNo);
        out.writeObject(street);
        out.writeObject(city);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        homeNo = in.readInt();
        street = (String) in.readObject();
        city = (String) in.readObject();
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
