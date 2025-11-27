package JH.WebscraperTest;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import java.io.*;
import org.jsoup.select.*;

public class Scraper{
	public static void main (String[] args){
//		films = ["https://www.synchronkartei.de/film/1467, https://www.synchronkartei.de/film/1469, https://www.synchronkartei.de/film/1468, https://www.synchronkartei.de/film/1421"]
		try {
			//Document doc = Jsoup.parse("https://www.synchronkartei.de/film/29457");
			Document doc = Jsoup.connect("https://www.synchronkartei.de/person/YsnQnNOBZ/sprecher").get();
//			Document doc = Jsoup.parse("<a>???<a><a href='lalal'>what?<a>");
			Elements spkr = doc.select("li");
			System.out.println(spkr.size());
			for (Element li : spkr){
				String inf = li.text();
				System.out.println(inf);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}

