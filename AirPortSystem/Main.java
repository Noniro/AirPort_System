package AirPortSystem;

import AirPortSystem.flights.Flight;
import AirPortSystem.flights.TravelFlight;

import java.time.LocalDateTime;

public class Main {
    static void createAirPort() {
        // company 1
        FlightCompany company1 = new TravelCompany("Vog Travels");
        // company 2
        FlightCompany company2 = new TravelCompany("El Al");
        // company 3
        FlightCompany company3 = new TravelCompany("Arkia");
        company2.addSubCompany(company3);

        //create fligts for companies
        company1.addFlight(new TravelFlight("Tel Aviv", "New York", LocalDateTime.of(2040,12,10,14,30),150, 1000.0, "1"));
        company2.addFlight(new TravelFlight("Tel Aviv", "New York", LocalDateTime.now(), 300, 1000.0, "2"));
        company3.addFlight(new TravelFlight("Tel Aviv", "New York", LocalDateTime.now(), 500, 1000.0, "3"));

        company1.newFlight("Miami", "New York", LocalDateTime.of(2040,1,1,14,30),120, 400.0, "5");
        company2.newFlight("Milano", "Tel Aviv", LocalDateTime.of(2030,5,10,14,30),360, 300.0, "6");
        company3.newFlight("Paris", "Tel Aviv", LocalDateTime.of(2029,1,10,20,30),390, 500.0, "7");
        // add the companies to the airport
        AirPort airPort = AirPort.getInstance();
        airPort.addCompany(company1);
        airPort.addCompany(company2);
        company1.cancelFlight("1");

    }


    public static void main(String[] args) {

        createAirPort();

        // use the facade like user
        AirPortFacade airPortFacade = new AirPortFacade();

        // print all flights
           System.out.println("All flights:");
           airPortFacade.getAllFlights().forEach(Flight::ToString);


        // print all flights by price
        System.out.println("All flights by price:");
        airPortFacade.searchFlights("price").forEach(Flight::ToString);

        //buy ticket
        Passenger passenger1 = new Passenger("Moshe", "123456789");
        Passenger passenger2 = new Passenger("David", "987654321");
        TravelFlight flight = (TravelFlight) airPortFacade.getAllFlights().get(0);
        airPortFacade.bookFlight(flight, passenger1);
        airPortFacade.subscribeToFlight(flight,passenger2);

        //delay the flight
        TravelFlight flightToDelay = (TravelFlight) airPortFacade.getAllFlights().get(0); // delay the first flight
        flightToDelay.delayFlight(120); // delay the flight by 2 hours

        // update the price of a flight
        TravelFlight flightToUpdatePrice = (TravelFlight) airPortFacade.getAllFlights().get(1); // update the price of the second flight
        flightToUpdatePrice.updatePrice(1200.0); // update the price to 1200.0

        //all flights after delaying a flight and updating the price of a flight
        System.out.println("All flights after delaying a flight number 2: ");
        AirPort.getInstance().getFlightByNumber("2").delayFlight(60);
        airPortFacade.getAllFlights().forEach(Flight::ToString);

        //unsubscribe from flight
        airPortFacade.unsubscribeFromFlight(flight,passenger2);

        //new flight for a company, register a passenger, then cancel the flight by flight number.
        Flight newflight = AirPort.getInstance().getCompanies().get(0).newFlight("Tel Aviv", "New York", LocalDateTime.now(), 150, 1000.0, "4");
        Passenger passenger3 = new Passenger("Yossi","111111111");
        airPortFacade.bookFlight(newflight,passenger3);
        airPortFacade.cancelFlight(AirPort.getInstance().getFlightByNumber("4"));

        //searching flights by date and time and print
        System.out.println("All flights by date and time:");
        airPortFacade.searchFlights("date").forEach(Flight::ToString);

        //searching flights by price
        System.out.println("All flights by price:");
        airPortFacade.searchFlights("price").forEach(Flight::ToString);

    }
}