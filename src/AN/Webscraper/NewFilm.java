package AN.Webscraper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;

public class NewFilm {
    public static void main(String[] args) {
    Gson gson = new Gson();
    Scanner scAddFilm = new Scanner(System.in);

    String[] films = null;

    try {
      String filmsJson = Files.readString(Paths.get("daten.json"));
      films = gson.fromJson(filmsJson, String[].class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Deine bekannten Filme: " + Arrays.toString(films));

    System.out.println("Welchen Film möchtest du hinzufügen? (ganzen Namen von synchronkartei.de angeben)");
      String newFilm = scAddFilm.nextLine();
      String[] newFilms = films + newFilm;

      try (FileWriter writer = new FileWriter("daten.json")) {
      gson.toJson(newFilms, writer);
    }
}
}
