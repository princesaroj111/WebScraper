package WebScrapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
  public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream("src/main/resources/linkedin_html.txt");

    String htmlDocument = IOUtils.toString(fis, StandardCharsets.UTF_8);
    Document document = Jsoup.parse(htmlDocument);
    int k = 5;
    List<List<Element>> grids = new WebScraper().getKLargestGridLinks(document, k);
    for (List<Element> grid : grids) {
      System.out.println("------------------------------GRID----------------------------------");
      for(Element element : grid){
        System.out.println(element.attr("href"));
      }
    }
  }

}
