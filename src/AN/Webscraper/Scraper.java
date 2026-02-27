package AN.Webscraper;

import java.util.Scanner;

import java.nio.file.*;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.helper.ValidationException;
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

    String currentWatchLink = "";

    String speakerLink = "";
    String speakerName = "";

    while (true) {
      while (true) {
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

        for (Film Film : allFilms) {
          if (currentWatch.equals(Film.title) || currentWatch.equals(Film.origTitle)) {
            currentWatchLink = Film.url;
          } else if (Film.altTitles != null) {
            for (String altTitle : Film.altTitles) {
              if (altTitle.equals(currentWatch)) {
                currentWatchLink = Film.url;
              }
            }
          }
        }
        if (currentWatchLink == "") {
          System.out.println("Diesen Film gibt es nicht.");
          break;
        } else {
          System.out.println("Film gefunden! Link: " + currentWatchLink);
        }

        System.out.println("Wessen Charakters Stimme kommt dir bekannt vor?");
        String currentWatchCharacter = sc.nextLine();

        try {
          Document filmDoc = Jsoup.connect(currentWatchLink).get();
          Elements allTds = filmDoc.select("td");
          Element formerTd = allTds.first();

          for (Element td : allTds) {
            if (td.text().equals(currentWatchCharacter)) {
              speakerName = formerTd.text();
              speakerLink = "https://www.synchronkartei.de" + formerTd.select("a").first().attr("href");
            }
            formerTd = td;
          }
          if (speakerLink == "") {
            System.out.println("Diesen Charakter gibt es nicht.");
            break;
          }
        } catch (ValidationException e) {
          System.out.println("Konnte nicht mit der Seite des Films verbinden:");
          e.printStackTrace();
          break;
        } catch (Exception e) {
          System.out.println("Fehler:");
          e.printStackTrace();
        }

        try {
          Document doc = Jsoup.connect(speakerLink).get();
          Elements roles = doc.select("li");

          System.out.println("Durchsuchen von " + roles.size() + " Sprechrollen von "
              + speakerName + "...");
          System.out.flush();

          Element role = null;
          for (Element li : roles) {
            String roleHTML = li.html();
            for (String film : knownFilms)
              if (roleHTML.contains(film + "</a>")) {
                role = li.getElementsByTag("em").first();
                System.out.println("Bekannte Rolle: " + role.text() + " aus " + film);
              }
          }
          if (role == null) {
            System.out.println("Keine Sprechrolle in deinen bekannten Filmen.");
          }
        } catch (ValidationException e) {
          System.out.println("Konnte nicht mit der Seite des Sprechers verbinden:");
          e.printStackTrace();
          break;
        } catch (Exception e) {
          System.out.println("Fehler:");
          e.printStackTrace();
        }
        break;
      }
      System.out.println("Möchtest du das Programm nochmal neu starten? (Ja/Nein)");
      String restart = sc.nextLine();
      if (restart.equalsIgnoreCase("Nein")) {
        break;
      }
    }
  }
}
