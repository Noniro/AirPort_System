package AirPortSystem;

import AirPortSystem.flights.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface FlightCompany { //component interface
    String getName();
    List<Flight> getFlights();
    Set<FlightCompany> getSubCompanies();
    void addFlight(Flight flight);
    void addSubCompany(FlightCompany company);
    void removeFlight(Flight flight);
    void removeSubCompany(FlightCompany company);
    Flight getFlight(String flightnumber);
    void cancelFlight(String flightnumber);
    Flight newFlight(String destination, String departure, LocalDateTime date, int duration, Double price, String flightNumber);
}
