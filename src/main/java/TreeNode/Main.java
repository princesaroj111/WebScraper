package TreeNode;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Create the three trees mentioned in assignment.
    TreeNode tree1 = new TreeNode("A", List.of(
        new TreeNode("B", List.of()),
        new TreeNode("C", List.of()),
        new TreeNode("A", List.of(
            new TreeNode("G", List.of()),
            new TreeNode("H", List.of())
        )),
        new TreeNode("B", List.of()),
        new TreeNode("E", List.of())));

    TreeNode tree2 = new TreeNode("A", List.of(
        new TreeNode("B", List.of()),
        new TreeNode("C", List.of(new TreeNode("I", List.of()))),
        new TreeNode("A", List.of(
            new TreeNode("G", List.of()),
            new TreeNode("H", List.of())
        )),
        new TreeNode("B", List.of()),
        new TreeNode("E", List.of())));

    TreeNode tree3 = new TreeNode("A", List.of(
        new TreeNode("B", List.of()),
        new TreeNode("C", List.of()),
        new TreeNode("A", List.of(
            new TreeNode("G", List.of(new TreeNode("K", List.of()))),
            new TreeNode("H", List.of())
        )),
        new TreeNode("B", List.of())));
    // Calculate the similarity scores.
    float similarityScore12 = TreeNodeSolution.treeSimilarityScore(tree1, tree2);
    float similarityScore23 = TreeNodeSolution.treeSimilarityScore(tree2, tree3);
    float similarityScore13 = TreeNodeSolution.treeSimilarityScore(tree1, tree3);

    // Print the similarity scores.
    System.out.println("The similarity score between tree1 and tree2 is " + similarityScore12);
    System.out.println("The similarity score between tree2 and tree3 is " + similarityScore23);
    System.out.println("The similarity score between tree1 and tree3 is " + similarityScore13);
  }
}
