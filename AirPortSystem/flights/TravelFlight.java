package AirPortSystem.flights;

import AirPortSystem.FlightNotificationSystem;
import AirPortSystem.Notification;
import AirPortSystem.Observer;
import AirPortSystem.Passenger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TravelFlight implements Flight {

    private final List<Passenger> passengers;
    private final List<Observer> subscribers;
    private FlightNotificationSystem notificationSystemPassengers;
    private FlightNotificationSystem notificationSystemSubscribers;
    private String departure;
    private String destination;

    private LocalDateTime arrivalTime;
    private LocalDateTime date;
    private int duration;
    private Double price;
    private String flightNumber;

    private static final List<String>flightIds  = new ArrayList<String>();
    private final int maxPassengers;

    public TravelFlight(String destination, String departure,LocalDateTime dateAndtime, int duration, Double price, String flightNumber){
        if (flightIds.contains(flightNumber)){
            throw new IllegalArgumentException("flights.Flight number:" +flightNumber+"already exists");
        }
        this.maxPassengers = 100; //each plane the same -\_(0_0)_/-
        this.departure = departure;
        this.destination = destination;
        this.date = dateAndtime;
        this.arrivalTime = dateAndtime.plusMinutes(duration);
        this.price = price;
        this.flightNumber = flightNumber;
        this.duration = duration;
        this.passengers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
        flightIds.add(flightNumber);
        this.notificationSystemPassengers = new FlightNotificationSystem();
        this.notificationSystemSubscribers = new FlightNotificationSystem();
    }

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String getDeparture() {
        return departure;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public Double getPrice() {
        return price;
    }
    @Override
    public void setPrice(Double price) {
        this.price = price;
    }
    //other getters and setters
    @Override
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
    @Override
    public Double getDuration() {
        return (double) duration;
    }
    @Override
    public LocalDateTime getDateAndTime() {
        return date;
    }
    @Override
    public void setDepartureTime(String departureTime) {
        this.date = LocalDateTime.parse(departureTime);
        this.arrivalTime = this.date.plusMinutes(duration);
    }
    @Override
    public int getDurationInMinutes() {
        return duration;
    }

    @Override
    public boolean isFull() {
        return maxPassengers <= passengers.size();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        notificationSystemPassengers.registerObserver(passenger);
    }
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        notificationSystemPassengers.removeObserver(passenger);
    }
    public void addSubscriber(Observer observer) {
        subscribers.add(observer);
        notificationSystemSubscribers.registerObserver(observer);
    }
    public void removeSubscriber(Observer observer) {
        subscribers.remove(observer);
        notificationSystemSubscribers.removeObserver(observer);
    }
    @Override
    public void delayFlight(int minutes) {
        this.date = this.date.plusMinutes(minutes);
        this.arrivalTime = this.arrivalTime.plusMinutes(minutes);
        System.out.println("flight number " + flightNumber + " has been delayed by " + minutes + " minutes"+ passengers.size() + " passengers have been notified");
        Notification notification = new Notification("flight number " + flightNumber + " has been delayed by " + minutes + " minutes");
        notificationSystemPassengers.notifyObservers(notification);
    }
    public void cancelFlight() {
        System.out.println("flight number " + flightNumber + " has been cancelled"+ passengers.size()+subscribers.size() + " passengers and subscribers have been notified");
        Notification notification = new Notification("flight number " + flightNumber + " has been cancelled");
        notificationSystemPassengers.notifyObservers(notification);
        notificationSystemSubscribers.notifyObservers(notification);
    }

    @Override
    public void ToString() {
        System.out.println("flight number: " + flightNumber);
        System.out.println("Date and time: " + date);
        System.out.println("Price: " + price);
        System.out.println("Duration: " + duration%60 + " hours and " + duration/60 + " minutes");
        System.out.println("~~~~~~~~~~~~~~~");
    }

    public void updatePrice(Double price) {
        System.out.println("flight number" + flightNumber + " price has been updated to: " + price);
        this.price = price;
        Notification notification = new Notification("flight number" + flightNumber + " price has been updated to: " + price);
        notificationSystemSubscribers.notifyObservers(notification);
    }




}
