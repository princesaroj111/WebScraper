package WebScrapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
  final static float SIMILARITY_THRESHOLD = (float) 0.80;

  public List<List<Element>> getKLargestGridLinks(Document document, int k) {
    Elements elements = document.select("*");
    List<List<Element>> grids = new ArrayList<>();

    for (Element element : elements) {
      if (isGrid(element)) {
        grids.add(getLinksGrid(element));
      }
    }

    grids.sort((o1, o2) -> Integer.compare(o2.size(), o1.size()));

    List<List<Element>> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      result.add(grids.get(i));
    }
    return result;
  }

  private boolean isGrid(Element element) {
    if (element == null) {
      return false;
    }
    List<Element> links = element.select("a");
    if (links.size() < 2) {
      return false;
    }
    List<Element> children = element.children();
    if (children.size() < 2) {
      return false;
    }
    float score = 0;
    int count = 0;
    for (int i = 0; i < children.size(); i++) {
      for (int j = 0; j < children.size(); j++) {
        if (i == j) {
          continue;
        }
        score = score + ElementNodeSolution.treeSimilarityScore(children.get(i), children.get(j));
        count++;
      }
    }

    return (score / count) > SIMILARITY_THRESHOLD;

  }

  private List<Element> getLinksGrid(Element element) {
    List<Element> links = element.select("a");
    return new ArrayList<>(links);
  }
}