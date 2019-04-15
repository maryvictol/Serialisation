package test.java;

import main.java.Actor;
import main.java.Film;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FilmTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createFilmWithOneActor() {
        Actor actor = new Actor("FirstName1","LastName1", "Country1");
        Film film = new Film("Film1" ,"Country1", 2000, actor);
        String result = "Film: Film1 (Country1, 2000)\n" +
                "Stars: FirstName1 LastName1 (Country1)\n";
        assertEquals("Incorrect Film: ", result, film.toString());
    }

    @Test
    public void createFilmWithThreeActors() {
        Set<Actor> actors = new HashSet<>();
        for (int i=0; i<=3; i++) {
            actors.add(new Actor("FirstName"+i,"LastName"+i, "Country"+i));
        }
        Film film = new Film("Film1" ,"Country1", 2000, actors);
        assertEquals("Incorrect Film: ", 4, film.getMainActors().size());
    }

    @Test
    public void createFilmWithNullFilmName() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Film Name shouldn't be empty.");
        Film film = new Film(null ,"Country1", 2000, new Actor("FirstName","LastName", "Country"));
    }

    @Test
    public void createFilmWithNullCountry() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Country shouldn't be empty.");
        Film film = new Film("FilmName" ,null, 2000, new Actor("FirstName","LastName", "Country"));
    }

    @Test
    public void createFilmWithNullRelease() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Release year shouldn't be 0.");
        Film film = new Film("FilmName" ,"Country", 0, new Actor("FirstName","LastName", "Country"));
    }

}