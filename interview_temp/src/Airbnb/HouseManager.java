package Airbnb;

import Airbnb.GeoLocation.Address;

import java.util.ArrayList;
import java.util.List;

public class HouseManager {
    private static HouseManager instance = null;

    public static HouseManager getInstance(){
        if(instance == null) {
            instance = new HouseManager();
        }

        return instance;
    }

    public List<House> searchByAddress(final Address address) {
        //Do some query operation or service call
        return new ArrayList<>();
    }

    public List<House> searchByZipcode(final int zipcode) {
        //Do some query operation or service call
        return new ArrayList<>();
    }
}
