package AirPortSystem;

public class Employee implements User,Observer{
    private String name;
    private String ID;

    public Employee(String name, String ID){
        this.name = name;
        this.ID = ID;
    }

    @Override
    public void update(Notification notification) {
        System.out.println("Employee " + name + " with ID " + ID + " received notification: " + notification.getMessage());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String ID() {
        return ID;
    }
}
