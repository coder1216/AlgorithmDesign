package Airbnb.GeoLocation;

public class Address {
    final String streetName;
    final String city;
    final int zipcode;
    final String state;

    //TODO: User Builder Design Pattern here
    public Address(final String streetName, final String city, final String state, final int zipcode){
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    // Creating toString
    @Override
    public String toString()
    {
        return String.format("Address [streetName=%s, city=%s, state=%s, zipcode=%s", streetName,city,state,zipcode);
    }
}
