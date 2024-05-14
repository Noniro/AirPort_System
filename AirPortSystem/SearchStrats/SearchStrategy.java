package AirPortSystem.SearchStrats;

import AirPortSystem.flights.Flight;

import java.util.List;

public interface SearchStrategy {
    List<Flight> search(List<Flight> flights);
}
