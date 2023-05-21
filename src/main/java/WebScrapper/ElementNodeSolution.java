package WebScrapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.jsoup.nodes.Element;

public class ElementNodeSolution {
  public static float treeSimilarityScore(Element root1, Element root2) {
    List<String> bfs1 = bfs(root1);
    List<String> bfs2 = bfs(root2);
    int lcs = lcs(bfs1, bfs2);

    return (float) lcs / Math.max(bfs1.size(), bfs2.size());
  }

  public static List<String> bfs(Element root) {
    List<String> traversal = new ArrayList<>();
    Queue<Element> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Element node = queue.poll();
      traversal.add(node.className());
      queue.addAll(node.children());
    }

    return traversal;
  }

  public static int lcs(List<String> list1, List<String> list2) {
    int n = list1.size();
    int m = list2.size();

    int[][] dp = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (list1.get(i - 1).equals(list2.get(j - 1))) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n][m];
  }
}
