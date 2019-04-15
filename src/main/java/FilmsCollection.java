package main.java;
import java.io.*;
import java.util.*;

public class FilmsCollection implements Serializable {
    private Set<Film> films;

    public FilmsCollection(){
        films = new HashSet<Film>();
    }

    public FilmsCollection(Film film) {
        this.films = new HashSet<>();
        setFilms(film);
    }

    public FilmsCollection(Set<Film> films) {
        this.films = new HashSet<>();
        setFilms(films);
    }

    public void setFilms(Film film){
        if (films == null) {
            throw new IllegalArgumentException("Films list shouldn't be null.");
        }
        this.films.add(film);
    }

    public void setFilms(Set<Film> films){
        if (films == null) {
            throw new IllegalArgumentException("Films list shouldn't be null.");
        }
        this.films=films;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void addFilmToCollection(Film newFilm) {
        films.add(newFilm);
    }

    public void deleteFilmFromCollection(Film film) {
        films.remove(film);
    }

    public void serialisationCollection(Object object, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialisationCollection(String fileName) {
        try (ObjectInputStream in =  new ObjectInputStream(new FileInputStream(fileName))) {
            FilmsCollection filmsCollection = (FilmsCollection)in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder filmCollectionInfo = new StringBuilder("Films collection:");
        if (films.size()!=0) {
            for (Film film : films) {
                filmCollectionInfo.append(film.toString());
            }
        }
        return filmCollectionInfo.toString();
    }

}

