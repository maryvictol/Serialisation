package main.java;
import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {
    private String filmName;
    private int release;
    private ArrayList<Actor> mainFilmActors;

    public Film(String filmName, int release, ArrayList<Actor> mainFilmActors) {
        this.filmName = filmName;
        this.release = release;
        this.mainFilmActors = mainFilmActors;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmName(){
        return filmName;
    }

    public void setMainActors(ArrayList<Actor> mainFilmActors) {
        this.mainFilmActors = mainFilmActors;
    }

    public ArrayList<Actor> getMainActors() {
        return mainFilmActors;
    }

    @Override
    public String toString() {
        String filmInfo = "Film: " + filmName + " (" + release + ")\n" + "Stars: ";
        for (Actor actor : mainFilmActors) {
            filmInfo += actor.toString() + "\n";
        }
        return filmInfo;
    }
}
