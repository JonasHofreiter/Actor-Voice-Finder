package AN.Webscraper;

import java.util.Scanner;

import java.nio.file.*;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import java.io.*;
import org.jsoup.select.*;

import com.google.gson.Gson;

public class Scraper {
  boolean isInstance(Object object, Class<?> type) {
    return type.isInstance(object);
  }

  public static void main(String[] args) {

    Gson gson = new Gson();
    Scanner sc = new Scanner(System.in);

    String[] knownFilms = null;
    Film[] allFilms = null;

    try {
      String knownFilmsJson = Files.readString(Paths.get("daten.json"));
      knownFilms = gson.fromJson(knownFilmsJson, String[].class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      String allFilmsJson = Files.readString(Paths.get("Synchronkartei/filme.json"));
      allFilms = gson.fromJson(allFilmsJson, Film[].class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Deine bekannten Filme: " + Arrays.toString(knownFilms));

    System.out.println("Welchen Film / Welche Serie schaust du gerade?");
    String currentWatch = sc.nextLine();

    System.out.println("Wessen Charakters Stimme kommt dir bekannt vor?");
    String currentWatchCharacter = sc.nextLine();

    String currentWatchLink = "";

    for (Film Film : allFilms) {
      if (currentWatch.equals(Film.title) || currentWatch.equals(Film.origTitle)) {
        currentWatchLink = Film.url;
        System.out.println(currentWatchLink);
      } else if (Film.altTitles != null) {
        for (String altTitle : Film.altTitles) {
          if (altTitle.equals(currentWatch)) {
            currentWatchLink = Film.url;
            System.out.println(currentWatchLink);
          }
        }
      }
    }

    try {
      Document filmDoc = Jsoup.connect(currentWatchLink).get();
      Elements allTDs = filmDoc.select("td");
      Element formerTD = allTDs.first();

      for (Element td : allTDs) {
        if (td.text().equals(currentWatchCharacter)) {
          System.out.println(formerTD);
        }
        formerTD = td;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    /*
     * System.out.println("Link des Sprechers eingeben:");
     * String speakerLink = sc.nextLine();
     * 
     * try {
     * Document doc = Jsoup.connect(speakerLink).get();
     * Elements speaker = doc.select("li");
     * Element speakerNameHTML = doc.select("h1").first();
     * 
     * System.out.println("Durchsuchen von " + speaker.size() + " Sprechrollen von "
     * + speakerNameHTML.text() + "...");
     * 
     * for (Element li : speaker) {
     * String roleHTML = li.html();
     * for (String film : knownFilms)
     * if (roleHTML.contains(film + "</a>")) {
     * Element role = li.getElementsByTag("em").first();
     * System.out.println("Bekannte Rolle: " + role.text() + " aus " + film);
     * }
     * }
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     */
  }
}
