package finalCSA;


import java.io.PrintStream;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeAnalyzer {
    // Part (a)
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        helper(res, root, hm);
        return res;
    }

    private String helper(List<TreeNode> res, TreeNode root, HashMap<String, Integer> hm) {
        if (root == null)
            return "#";
        String left = helper(res, root.left, hm);
        String right = helper(res, root.right, hm);
        String stringFormed = root.val + "," + left + "," + right;
        if (hm.getOrDefault(stringFormed, 0) == 1) {
            res.add(root);
        }
        hm.put(stringFormed, hm.getOrDefault(stringFormed, 0) + 1);
        return stringFormed;
    }

    // Part (b)
    public int sumOfNodesInDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees(root);
        int sum = 0;
        for (TreeNode subtreeRoot : duplicateSubtrees) {
            sum += countNodes(subtreeRoot);
        }
        return sum;
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Method to display the tree in text format
    public void displayTree(TreeNode root) {
        print(System.out, root);
    }

    // Print method using PrintStream
    public void print(PrintStream os, TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, root, "", true);
        os.print(sb.toString());
    }

    // Helper method to traverse the tree and build the string representation
    private void traversePreOrder(StringBuilder sb, TreeNode node, String padding, boolean last) {
        if (node != null) {
            sb.append(padding);
            sb.append(last ? "└── " : "├── ");
            sb.append(node.val);
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append(last ? "    " : "│   ");
            String newPadding = paddingBuilder.toString();

            List<TreeNode> children = new ArrayList<>(2);
            children.add(node.left);
            children.add(node.right);

            for (int i = 0; i < children.size(); i++) {
                traversePreOrder(sb, children.get(i), newPadding, i == children.size() - 1);
            }
        } else {
            sb.append(padding);
            sb.append(last ? "└── " : "├── ");
            sb.append("*");
            sb.append("\n");
        }
    }
}