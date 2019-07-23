package practice.interviewguide.tree;

import java.util.Stack;

/**
 * 递归和非递归方式实现遍历
 * */
public class Traversing {
    /**-----------递归-----------**/
    public void preOrder(TreeNode root){
        if (root == null)return;
        if (root != null) {
            System.out.println(root.getValue());
        }
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    public void inOrder(TreeNode root){
        if (root == null)return;
        inOrder(root.getLeft());
        if (root != null) {
            System.out.println(root.getValue());
        }
        inOrder(root.getRight());
    }
    public void posOrder(TreeNode root){
        if (root == null)return;
        posOrder(root.getLeft());
        posOrder(root.getRight());
        if (root != null) {
            System.out.println(root.getValue());
        }
    }

    /**-----------非递归-----------**/
    public void preOrderUnRecur(TreeNode root){
        if (root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(! stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(root.getValue());
            if (node.getRight() != null) {
                stack.add(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.add(node.getLeft());
            }
        }
    }
    public void inOrderUnRecur(TreeNode root){
        if (root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        while(! stack.empty() || root != null) {
            if (root != null) {
                //一直向左
                stack.add(root);
                root = root.getLeft();
            }
            //到了左边尽头之后输出中点,然后访问右节点
            else {
                TreeNode node = stack.pop();
                System.out.println(node.getValue());
                root = node.getRight();
            }
        }
    }

    /**后序遍历,先访问左边再访问右边,最后访问中点,按此顺序逆序压栈*/
    public void posUnRecur(TreeNode root){
        if (root == null)return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (! stack1.empty()) {
            TreeNode node = stack1.pop();
            stack2.add(node);
            if (node.getLeft() != null) {
                stack1.add(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.add(node.getRight());
            }
        }
        while(! stack2.empty()) {
            System.out.println(stack2.pop().getValue());
        }
    }

}
