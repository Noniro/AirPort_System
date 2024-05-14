package AirPortSystem.flights;

import AirPortSystem.Passenger;

import java.time.LocalDateTime;

//this is the interface for the flight class
//so we could have different types of flights (for now just TravelFlight).
public interface  Flight {
    String getFlightNumber();
    String getDeparture();
    String getDestination();
    LocalDateTime getArrivalTime();
    Double getPrice();
    Double getDuration();
    LocalDateTime getDateAndTime();
    void setPrice(Double price);
    void setDepartureTime(String departureTime);
    int getDurationInMinutes();
    boolean isFull();
    void addPassenger(Passenger passenger);
    void cancelFlight();
    void delayFlight(int minutes);
    void ToString();


}
