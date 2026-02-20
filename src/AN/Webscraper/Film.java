package AN.Webscraper;

public class Film {
  int id;
  String title;
  String origTitle;
  String[] altTitles;
  String year;
  int tmdbId;
  String url;

  @Override
  public String toString() {
    return title + " (" + year + ")";
  }
}
