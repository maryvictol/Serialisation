package main.java;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class FilmsCollection implements Serializable {
    private ArrayList<Film> films;

    public FilmsCollection(){
        films = new ArrayList<Film>();
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addFilmToCollection(Film newFilm) {
        films.add(newFilm);
    }

    public boolean deleteFilmFromCollectionByName(String name) {
        boolean flag = films.removeIf(film -> film.getFilmName().equals(name));
        if (!flag) {
            System.out.println("Film " + name + "hasn't been found");
        }
        return flag;
    }

    public boolean deleteActorFromFilm(String filmName, String name) {
        boolean flag = false;
        for (Film film : films){
            if (film.getFilmName().equals(filmName)) {
                flag = film.getMainActors().removeIf(actor -> film.getMainActors().equals(name));
            }
         }
        if (!flag) {
            System.out.println("Actor " + name + "hasn't been found");
        }
        return flag;
    }

    public void addActorToMainActorsList(String filmName, String name) {

    }

}

