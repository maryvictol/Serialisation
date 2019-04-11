package main.java;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;


public class Main {

    public static void main(String[] args) {

        FilmsCollection filmsCollection = new FilmsCollection();

        //Create actors
        Actor actor1 = new Actor("Tom", "Hanks");
        Actor actor2 = new Actor("Catherine", "Zeta-Jones");
        Actor actor3 = new Actor("Helen", "Hunt");
        Actor actor4 = new Actor("Antonio", "Banderas");
        Actor actor5 = new Actor("Anthony", "Hopkins");

        //Create films collection
        Actor [] arrayActors = {actor1,actor2};
        ArrayList<Actor> listActors = new ArrayList<Actor> (Arrays.asList(arrayActors));
        Film film = new Film("The Terminal", 2004, listActors);
        filmsCollection.addFilmToCollection(film);

        arrayActors[1] = actor3;
        listActors = new ArrayList<Actor> (Arrays.asList(arrayActors));
        film = new Film("Cast Away", 2000, listActors);
        filmsCollection.addFilmToCollection(film);

        Actor [] arrayActors1 = {actor2, actor4, actor5};
        listActors  = new ArrayList<Actor> (Arrays.asList(arrayActors));
        film = new Film("The Mask of Zorro", 1998, listActors);
        filmsCollection.addFilmToCollection(film);


        //Serialisation
        filmsCollection.serialisationCollection(filmsCollection,"result.bin");

        filmsCollection.deserialisationCollection("result.bin");
        System.out.println("");

    }
}
