package main.java;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Film implements Serializable {

    private String filmName;
    private String country;
    private int release;
    private Set<Actor> mainFilmActors;

    public Film(String filmName, String country, int release, Set<Actor> mainFilmActors) {
        setFilmName(filmName);
        setCountry(country);
        setRelease(release);
        setMainActors(mainFilmActors);
    }

    public Film(String filmName, String country, int release, Actor actor) {
        setFilmName(filmName);
        setCountry(country);
        setRelease(release);
        setMainActors(actor);
    }

    public void setFilmName(String filmName) {
        if (filmName == null || filmName == "") {
            throw new IllegalArgumentException("Film Name shouldn't be empty.");
        }
        this.filmName = filmName;
    }

    public String getFilmName(){
        return filmName;
    }

    public void setRelease(int release) {
        if (release == 0) {
            throw new IllegalArgumentException("Release year shouldn't be 0.");
        }
        this.release = release;
    }

    public int getRelease(){
        return release;
    }

    public void setCountry(String country) {
        if (country == null) {
            throw new IllegalArgumentException("Country shouldn't be empty.");
        }
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void setMainActors(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("Actors List shouldn't be null.");
        }
        this.mainFilmActors = new HashSet<>();
        this.mainFilmActors.add(actor);
    }

    public void setMainActors(Set<Actor> mainFilmActors) {
        if (mainFilmActors == null) {
            throw new IllegalArgumentException("Actors List shouldn't be null.");
        }
        this.mainFilmActors = new HashSet<>();
        this.mainFilmActors = mainFilmActors;
    }

    public Set<Actor> getMainActors() {
        return mainFilmActors;
    }

    public void addActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("Actor shouldn't be null.");
        }
        mainFilmActors.add(actor);
    }

    public void deleteActor(Actor actor){
        mainFilmActors.remove(actor);
    }

    @Override
    public boolean equals(Object compareObject) {
        if (compareObject == null) {
            return false;
        }
        if (!(compareObject instanceof Film)) {
            return false;
        }
        Film compareFilm = (Film) compareObject;
        return (Objects.equals(filmName, compareFilm.filmName) &&
                Objects.equals(mainFilmActors, compareFilm.mainFilmActors) &&
                Objects.equals(release, compareFilm.release) &&
                Objects.equals(country, compareFilm.country));
    }

    @Override
    public String toString() {
        String filmInfo = "Film: " + filmName + " (" + country + ", " + release + ")\n" + "Stars: ";
        for (Actor actor : mainFilmActors) {
            filmInfo = filmInfo + actor.toString() + "\n";
        }
        return filmInfo;
    }
}
