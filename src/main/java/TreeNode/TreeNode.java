package TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
  String value;
  List<TreeNode> children;

  public TreeNode(String value, List<TreeNode> children) {
    this.value = value;
    this.children = children;
  }

  public TreeNode(String value) {
    this.value = value;
    this.children = new ArrayList<>();
  }
}