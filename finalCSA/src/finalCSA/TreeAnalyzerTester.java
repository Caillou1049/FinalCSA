package finalCSA;

import java.util.List;

public class TreeAnalyzerTester {
    public static void main(String[] args) {
        // Test Case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(4);
        root1.right.left.left = new TreeNode(4);

        // Create an instance of TreeAnalyzer
        TreeAnalyzer analyzer = new TreeAnalyzer();

        // Display the binary tree
        System.out.println("Binary Tree:");
        analyzer.displayTree(root1);

        // Test Part (a)
        System.out.println("\nDuplicate Subtrees:");
        List<TreeNode> duplicateSubtrees = analyzer.findDuplicateSubtrees(root1);
        for (TreeNode subtree : duplicateSubtrees) {
            System.out.print(subtree.val);
            if (subtree.left != null || subtree.right != null) {
                System.out.print(", ");
                if (subtree.left != null) {
                    System.out.print(subtree.left.val);
                }
                if (subtree.right != null) {
                    System.out.print(", " + subtree.right.val);
                }
            }
            System.out.println();
        }

        // Test Part (b)
        int sum = analyzer.sumOfNodesInDuplicateSubtrees(root1);
        System.out.println("\nSum of nodes in duplicate subtrees: " + sum);

        // Additional Test Cases
        System.out.println("\n--- Additional Test Cases ---");

        // Test Case 2: Tree with no duplicates
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println("\nBinary Tree:");
        analyzer.displayTree(root2);

        System.out.println("\nDuplicate Subtrees:");
        duplicateSubtrees = analyzer.findDuplicateSubtrees(root2);
        for (TreeNode subtree : duplicateSubtrees) {
            System.out.println(subtree.val);
        }

        sum = analyzer.sumOfNodesInDuplicateSubtrees(root2);
        System.out.println("\nSum of nodes in duplicate subtrees: " + sum);

        // Test Case 3: Tree where all nodes have the same value
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(1);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(1);
        root3.right.left = new TreeNode(1);
        root3.right.right = new TreeNode(1);

        System.out.println("\nBinary Tree:");
        analyzer.displayTree(root3);

        System.out.println("\nDuplicate Subtrees:");
        duplicateSubtrees = analyzer.findDuplicateSubtrees(root3);
        for (TreeNode subtree : duplicateSubtrees) {
            System.out.print(subtree.val);
            if (subtree.left != null || subtree.right != null) {
                System.out.print(", ");
                if (subtree.left != null) {
                    System.out.print(subtree.left.val);
                }
                if (subtree.right != null) {
                    System.out.print(", " + subtree.right.val);
                }
            }
            System.out.println();
        }

        sum = analyzer.sumOfNodesInDuplicateSubtrees(root3);
        System.out.println("\nSum of nodes in duplicate subtrees: " + sum);

        // Test Case 4: Complex Tree
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.left = new TreeNode(2);
        root4.right.right = new TreeNode(4);
        root4.right.left.left = new TreeNode(4);
        root4.right.left.right = new TreeNode(5);

        System.out.println("\nBinary Tree:");
        analyzer.displayTree(root4);

        System.out.println("\nDuplicate Subtrees:");
        duplicateSubtrees = analyzer.findDuplicateSubtrees(root4);
        for (TreeNode subtree : duplicateSubtrees) {
            System.out.print(subtree.val);
            if (subtree.left != null || subtree.right != null) {
                System.out.print(", ");
                if (subtree.left != null) {
                    System.out.print(subtree.left.val);
                }
                if (subtree.right != null) {
                    System.out.print(", " + subtree.right.val);
                }
            }
            System.out.println();
        }

        sum = analyzer.sumOfNodesInDuplicateSubtrees(root4);
        System.out.println("\nSum of nodes in duplicate subtrees: " + sum);
    }
}