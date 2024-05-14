package AirPortSystem;

import java.util.HashSet;
import java.util.Set;

public class FlightNotificationSystem implements Subject {
    private Set<Observer> observers;
    private String message;
    public FlightNotificationSystem() {
        this.observers = new HashSet<>();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(Notification notification) {
        for(Observer observer: observers){
            observer.update(notification);
        }

    }
}
