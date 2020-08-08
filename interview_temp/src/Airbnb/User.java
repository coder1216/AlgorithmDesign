package Airbnb;

import Airbnb.GeoLocation.Address;

import java.util.List;

public class User {
    private final String userId;
    private UserType type;

    public User(final String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserType(final UserType userType){
        this.type = userType;
    }

    // by address
    public List<House> searchHouse(final Address address){
        final HouseManager houseManager = HouseManager.getInstance();
        return houseManager.searchByAddress(address);
    }

    // by zipcode
    public List<House> searchHouse(final int zipcode){
        final HouseManager houseManager = HouseManager.getInstance();
        return houseManager.searchByZipcode(zipcode);
    }
}
