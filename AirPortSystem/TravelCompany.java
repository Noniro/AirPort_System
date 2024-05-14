package AirPortSystem;

import AirPortSystem.flights.Flight;
import AirPortSystem.flights.TravelFlight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TravelCompany implements FlightCompany{
    private final String name;
    private final List<Employee> employees; //for future use (pilots , flight attendants etc)
    private final List<Flight> flights;
    private final Set<FlightCompany> subCompanies;


    public TravelCompany(String name) {
        this.employees = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.subCompanies = new HashSet<>();
        this.name = name;
        }

        @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Flight> getFlights() {
        return flights;
    }

    @Override
    public Set<FlightCompany> getSubCompanies() {
        return subCompanies;
    }

    @Override
    public void addFlight(Flight flight) {
            boolean flightExists = flights.stream().anyMatch(f -> f.getFlightNumber().equals(flight.getFlightNumber()));
            if (flightExists) {
                throw new IllegalArgumentException("Flight number already exists in the company! Please enter a new flight number.");
            }else {
                flights.add(flight);
            }
    }
    @Override
    public Flight newFlight(String destination, String departure,LocalDateTime date, int duration, Double price, String flightNumber){
            if (flights.stream().anyMatch(f -> f.getFlightNumber().equals(flightNumber))) {
                throw new IllegalArgumentException("Flight number already exists! Please enter a new flight number.");
            }
        Flight flight = new TravelFlight( destination, departure, date, duration, price, flightNumber);
        flights.add(flight);
        return flight;
    }

    @Override
    public void addSubCompany(FlightCompany company) {
        subCompanies.add(company);
    }

    @Override
    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    @Override
    public void removeSubCompany(FlightCompany company) {
        subCompanies.remove(company);
    }



    @Override
    public Flight getFlight(String flightnumber) {
        return flights.stream().filter(f -> f.getFlightNumber().equals(flightnumber)).findFirst().orElse(null);
    }

    @Override
    public void cancelFlight(String flightnumber) {
        Flight flight = flights.stream().filter(f -> f.getFlightNumber().equals(flightnumber)).findFirst().orElse(null);
        flights.remove(flight);
    }
}
