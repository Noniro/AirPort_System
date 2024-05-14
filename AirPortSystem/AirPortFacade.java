package AirPortSystem;

import AirPortSystem.flights.Flight;
import AirPortSystem.flights.TravelFlight;

import java.util.List;

public class AirPortFacade {

    public List<Flight> getAllFlights(){
        return AirPort.getInstance().getAllFlights();
    }

    public List<Flight> searchFlights(String type){
        return AirPort.getInstance().searchFlights(type);
    }

    public void bookFlight(Flight flight, Passenger passenger){
        flight.addPassenger(passenger);
    }

    public void cancelFlight(Flight flight){
        flight.cancelFlight();
    }

    public void  subscribeToFlight(TravelFlight flight, User user){
        flight.addSubscriber(user);
    }
    public void unsubscribeFromFlight(TravelFlight flight, User user){
        flight.removeSubscriber(user);
    }

}
