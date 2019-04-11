package main.java;
import java.io.Serializable;

public class Actor implements Serializable {
    private String firstName;
    private String lastName;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
     }

     @Override
    public String toString() {
        return firstName + " " + lastName;
     }
}
