package Airbnb;

import Airbnb.GeoLocation.Address;

import java.util.Set;
import java.util.TreeSet;

public class House {
    final String id;

    final Address address;

    final int capacity;

    final String ownerId;

    final Set<String> reservations;

    public House(final String id, final Address address, final int capacity, final String ownerId){
        this.id = id;
        this.address = address;
        this.capacity = capacity;
        this.ownerId = ownerId;
        reservations = new TreeSet<>();
    }

    public Address getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Set<String> getReservations() {
        return reservations;
    }

    public void addReservations(final String reservationId){
        reservations.add(reservationId);
    }
}
