package AirPortSystem;

public class Passenger implements User, Observer{
    private String name;
    private String ID;

    public Passenger(String name, String ID){
        this.name = name;
        this.ID = ID;
    }

    @Override
    public void update(Notification notification) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String ID() {
        return null;
    }
}
