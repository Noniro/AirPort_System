package AirPortSystem.SearchStrats;

import AirPortSystem.flights.Flight;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByDurationStrategy implements SearchStrategy {

    @Override
    public List<Flight> search(List<Flight> flights) {
        System.out.println("Searching by duration...");
        return flights.stream()
                .sorted(Comparator.comparingDouble(Flight::getDuration))
                .collect(Collectors.toList());
    }
}
