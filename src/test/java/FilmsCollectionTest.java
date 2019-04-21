package test.java;

import main.java.Actor;
import main.java.Film;
import main.java.FilmsCollection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.HashSet;
import java.util.Set;

import test.java.FilmTest;

import static org.junit.Assert.*;

public class FilmsCollectionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkFilmCollectionConstructorWithOneFilm() {
        Film film = FilmTest.createFilmForTest("Film1", "Country1", 2000, 10);
        FilmsCollection filmsCollection = new FilmsCollection(film);
        String actualResult = filmsCollection.toString();
        String expectedResult = "Films collection:Film: Film1 (Country1, 2000)\n" +
                "Stars: FirstName0 LastName0 (Country0)\n" +
                "FirstName9 LastName9 (Country9)\n" +
                "FirstName7 LastName7 (Country7)\n" +
                "FirstName8 LastName8 (Country8)\n" +
                "FirstName5 LastName5 (Country5)\n" +
                "FirstName6 LastName6 (Country6)\n" +
                "FirstName2 LastName2 (Country2)\n" +
                "FirstName1 LastName1 (Country1)\n" +
                "FirstName4 LastName4 (Country4)\n" +
                "FirstName3 LastName3 (Country3)\n";
        assertEquals(1, filmsCollection.getFilms().size());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkFilmCollectionConstructorWithSeveralFilms() {
        Set<Film> films = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Film newFilm = FilmTest.createFilmForTest("FilmName" + i, "Country" + i, 2000, 10);
            films.add(newFilm);
        }
        FilmsCollection filmsCollection = new FilmsCollection(films);
        assertEquals(10, filmsCollection.getFilms().size());
    }

    @Test
    public void newFilmIsAddedToCollection() {
        Set<Film> films = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Film newFilm = FilmTest.createFilmForTest("FilmName" + i, "Country" + i, 2000, 10);
            films.add(newFilm);
        }
        FilmsCollection filmsCollection = new FilmsCollection(films);
        int initialFilmsNumber = filmsCollection.getFilms().size();
        Film newFilm = FilmTest.createFilmForTest("FilmName11", "Country11", 2011, 10);
        filmsCollection.addFilmToCollection(newFilm);
        assertEquals(initialFilmsNumber + 1, filmsCollection.getFilms().size());
    }

    @Test
    public void existingFilmIsNotAddedToCollection() {
        Set<Film> films = new HashSet<>();
        for (int i = 0; i <= 10; i++) {
            Film newFilm = FilmTest.createFilmForTest("FilmName" + i, "Country" + i, 2000, 10);
            films.add(newFilm);
        }
        FilmsCollection filmsCollection = new FilmsCollection(films);
        int initialFilmsNumber = filmsCollection.getFilms().size();
        Film existingFilm = FilmTest.createFilmForTest("FilmName10", "Country10", 2000, 10);
        filmsCollection.addFilmToCollection(existingFilm);
        assertEquals(initialFilmsNumber, filmsCollection.getFilms().size());
    }

    @Test
    public void existingFilmIsDeleteFromCollection() {
        Set<Film> films = new HashSet<>();
        for (int i = 0; i <= 10; i++) {
            Film newFilm = FilmTest.createFilmForTest("FilmName" + i, "Country" + i, 2000, 10);
            films.add(newFilm);
        }
        FilmsCollection filmsCollection = new FilmsCollection(films);
        int initialFilmsNumber = filmsCollection.getFilms().size();
        Film existingFilm = FilmTest.createFilmForTest("FilmName10", "Country10", 2000, 10);
        filmsCollection.deleteFilmFromCollection(existingFilm);
        assertEquals(initialFilmsNumber - 1, filmsCollection.getFilms().size());
    }

    @Test
    public void nonExistingFilmIsDeleteFromCollection() {
        Set<Film> films = new HashSet<>();
        for (int i = 0; i <= 10; i++) {
            Film newFilm = FilmTest.createFilmForTest("FilmName" + i, "Country" + i, 2000, 10);
            films.add(newFilm);
        }
        FilmsCollection filmsCollection = new FilmsCollection(films);
        int initialFilmsNumber = filmsCollection.getFilms().size();
        Film existingFilm = FilmTest.createFilmForTest("FilmName10", "Country10", 2010, 10);
        filmsCollection.deleteFilmFromCollection(existingFilm);
        assertEquals(initialFilmsNumber, filmsCollection.getFilms().size());
    }

    @Test
    public void checkSerialisationFilmCollection() {
        Set<Film> films = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Film newFilm = FilmTest.createFilmForTest("FilmName" + i, "Country" + i, 2000, 10);
            films.add(newFilm);
        }
        FilmsCollection initialFilmsCollection = new FilmsCollection(films);
        initialFilmsCollection.serialisationCollection(initialFilmsCollection,"result.bin");
        FilmsCollection deserialisationFilmsCollection = FilmsCollection.deserialisationCollection("result.bin");
        assertEquals(10, deserialisationFilmsCollection.getFilms().size());
    }

    @Test
    public void checkDeserialisationNonExistingFileWithFilmCollection() {
        assertNull(FilmsCollection.deserialisationCollection("result11.bin"));
    }

    @Test
    public void checkDeserialisationIncorrectFileWithFilmCollection(){
        assertNull(FilmsCollection.deserialisationCollection("src/incorrectResult.bin"));
    }
}
