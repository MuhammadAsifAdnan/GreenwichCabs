/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;

import java.util.Date;

/**
 *
 * @author aa
 */
public class Journey {
    private int driverId;
    private String timeOfJourney;
    private String pickupLocation;
    private String Destination;
    private String passengerName;
    private Double fare;
    private String account;
    private String telephone;

    public Journey(int driverId, String timeOfJourney, String pickupLocation, String Destination, String passengerName, Double fare, String account, String telephone) {
        this.driverId = driverId;
        this.timeOfJourney = timeOfJourney;
        this.pickupLocation = pickupLocation;
        this.Destination = Destination;
        this.passengerName = passengerName;
        this.fare = fare;
        this.account = account;
        this.telephone = telephone;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getTimeOfJourney() {
        return timeOfJourney;
    }

    public void setTimeOfJourney(String timeOfJourney) {
        this.timeOfJourney = timeOfJourney;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

   
}
