package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.*;


public class Main {

    public static void main(String[] args) {



        //Create actors and films
        Set<Actor> actors = new HashSet<>();
        for (int i=0; i<=3; i++) {
            actors.add(new Actor("FirstName"+i,"LastName"+i, "Country"+i));
        }
        Film film1 = new Film("Film1" ,"Country1", 2000, actors);

        Set<Actor> actors1 = new HashSet<>();
        for (int i=1; i<=5; i++) {
            actors.add(new Actor("FirstName"+i,"LastName"+i, "Country"+i));
        }
        Film film2 = new Film("Film1" ,"Country1", 2000, actors);

        Set<Film> films = new HashSet<>();
        films.add(film1);
        films.add(film2);

        //Create films collection
        FilmsCollection filmsCollection = new FilmsCollection(films);


        //Serialisation
        filmsCollection.serialisationCollection(filmsCollection,"result.bin");

        filmsCollection.deserialisationCollection("result.bin");
        System.out.println("");

    }
}
