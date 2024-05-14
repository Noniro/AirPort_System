package AirPortSystem;

public interface User extends Observer { // can later be used to create more types of users(for now just simple airport employee).
    String getName();
    String ID();

}
