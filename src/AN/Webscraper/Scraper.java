package AN.Webscraper;

import java.util.Scanner;
import java.nio.file.*;
import java.util.Arrays;

import java.io.*;

import com.google.gson.Gson;

public class Scraper {
  public static void main(String[] args) {
    Gson gson = new Gson();
    Scanner sc = new Scanner(System.in);

    String[] films = null;

    try {
      String filmsJson = Files.readString(Paths.get("daten.json"));
      films = gson.fromJson(filmsJson, String[].class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Deine bekannten Filme: " + Arrays.toString(films));

    System.out.println("Link des Sprechers eingeben:");
    String speakerLink = sc.nextLine();

    try {
      Document doc = Jsoup.connect(speakerLink).get();
      Elements speaker = doc.select("li");
      Element speakerNameHTML = doc.select("h1").first();

      System.out.println("Durchsuchen von " + speaker.size() + " Sprechrollen von " + speakerNameHTML.text() + "...");

      for (Element li : speaker) {
        String roleHTML = li.html();
        for (String film : films)
          if (roleHTML.contains(film + "</a>")) {
            Element role = li.getElementsByTag("em").first();
            System.out.println("Bekannte Rolle: " + role.text() + " aus " + film);
          }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
