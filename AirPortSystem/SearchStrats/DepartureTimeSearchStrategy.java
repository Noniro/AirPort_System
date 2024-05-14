package AirPortSystem.SearchStrats;

import AirPortSystem.flights.Flight;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureTimeSearchStrategy implements SearchStrategy {

    @Override
    public List<Flight> search(List<Flight> flights) {
        System.out.println("Searching by departure time...");
        return flights.stream()
                .sorted(Comparator.comparing(Flight::getDateAndTime))
                .collect(Collectors.toList());
    }
}
