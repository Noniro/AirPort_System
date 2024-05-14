package AirPortSystem;

import AirPortSystem.SearchStrats.SearchStrategyFactory;
import AirPortSystem.flights.Flight;
import AirPortSystem.flights.TravelFlight;

import java.util.LinkedList;
import java.util.List;

public class AirPort {
    private static AirPort instance;

    public static AirPort getInstance() {
        if (instance == null) {
            instance = new AirPort();
        }
        return instance;
    }

    private final List<FlightCompany> companies;
    private final List<Employee> employees;
    private final SearchStrategyFactory searchStrategyFactory;

    private AirPort() {
        companies = new LinkedList<>();
        employees = new LinkedList<>();
        searchStrategyFactory = new SearchStrategyFactory();
    }

    public void addCompany(FlightCompany company) {
        if(companies.contains(company)) {
            throw new IllegalArgumentException("Company already exists");
        }

        companies.add(company);
    }

    public void removeCompany(FlightCompany company) {
        companies.remove(company);
    }

    public List<FlightCompany> getCompanies() {
        return companies;
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new LinkedList<>();
        for (FlightCompany company : companies) {
            flights.addAll(company.getFlights());
        }
        return flights;
    }

    public List<Flight> searchFlights(String type) {
        List<Flight> flights = getAllFlights();

        return searchStrategyFactory.createSearchStrategy(type).search(flights);
    }
    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }

    }
    public void buyTicket(TravelFlight flight, Passenger passenger) {
        if(flight.isFull()) {
            throw new IllegalArgumentException("Flight is full");
        }
        flight.addPassenger(passenger);
        }
    public Flight getFlightByNumber(String flightNumber) {
        for (FlightCompany company : companies) {
            for (Flight flight : company.getFlights()) {
                if (flight.getFlightNumber().equals(flightNumber)) {
                    return flight;
                }
            }
        }
        return null;
    }

}
