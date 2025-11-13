package JH.WebscraperTest;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;

public class Scraper{
	public static void main (String[] args){
//		films = ["https://www.synchronkartei.de/film/1467, https://www.synchronkartei.de/film/1469, https://www.synchronkartei.de/film/1468, https://www.synchronkartei.de/film/1421"]
		Document doc = null;
		Element spkr = null;
		String inf = null;
		try {
			doc = Jsoup.parse("https://www.synchronkartei.de/film/29457");
			spkr = doc.select("tbody").first();
			inf = spkr.body() .text();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}

