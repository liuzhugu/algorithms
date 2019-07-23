package practice.interviewguide;

import practice.interviewguide.tree.Traversing;
import practice.interviewguide.tree.TreeNode;

public class InterViewTest {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root1.setLeft(root2);
        root1.setRight(root3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root2.setLeft(root4);
        root2.setRight(root5);
        Traversing traversing = new Traversing();
        traversing.inOrder(root1);
        traversing.inOrderUnRecur(root1);
    }
}
