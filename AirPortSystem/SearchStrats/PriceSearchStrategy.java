package AirPortSystem.SearchStrats;

import AirPortSystem.flights.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class PriceSearchStrategy implements SearchStrategy {

    @Override
    public List<Flight> search(List<Flight> flights) {
        System.out.println("Searching by price...");
        return flights.stream()
                .sorted(
                        (flight1,flight2) -> Double.compare(flight1.getPrice(), flight2.getPrice())
                )
                .collect(Collectors.toList());
    }
}
