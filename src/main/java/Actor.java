package main.java;
import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable {
    private String firstName;
    private String lastName;
    private String country;

    public Actor(String firstName, String lastName, String country) {
        setFirstName(firstName);
        setLastName(lastName);
        setCountry(country);
     }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName == "") {
            throw new IllegalArgumentException("First Name shouldn't be empty.");
        }
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName == "") {
            throw new IllegalArgumentException("Last Name shouldn't be empty.");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCountry(String country) {
        if (country == null) {
            throw new IllegalArgumentException("Country shouldn't be null.");
        }
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName, lastName, country);
    }

    @Override
    public boolean equals(Object compareObject) {
        if (compareObject == null) {
            return false;
        }
        if (this == compareObject) {
            return true;
        };
        if (!(compareObject instanceof Actor)) {
            return false;
        }
        Actor compareActor = (Actor) compareObject;
        return (Objects.equals(firstName, compareActor.firstName) &&
                Objects.equals(lastName, compareActor.lastName) &&
                Objects.equals(country, compareActor.country));
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + country + ")";
     }
}
