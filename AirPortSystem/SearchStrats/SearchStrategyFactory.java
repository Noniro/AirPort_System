package AirPortSystem.SearchStrats;

public class SearchStrategyFactory {
    public SearchStrategy createSearchStrategy(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "price":
                return new PriceSearchStrategy();
            case "date":
                return new DepartureTimeSearchStrategy();
            case "duration":
                return new SearchByDurationStrategy();
            default:
                throw new IllegalArgumentException("Invalid search strategy type");
        }
    }

}

