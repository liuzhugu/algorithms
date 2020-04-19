package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/03/14.
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
 * 则将 next 指针设置为 NULL。初始状态下，所有 next 指针都被设置为 NULL
 */
public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> currentNodes = new ArrayList<>();
        currentNodes.add(root);
        List<Node> nextNodes = new ArrayList<>();
        while(currentNodes.size() != 0){
            for (int i = 0;i < currentNodes.size() - 1;i ++) {
                Node node = currentNodes.get(i);
                node.next = currentNodes.get(i + 1);
                if (node.left != null) {
                    nextNodes.add(node.left);
                }
                if (node.right != null) {
                    nextNodes.add(node.right);
                }
            }
            Node node = currentNodes.get(currentNodes.size() - 1);
            if (node.left != null) {
                nextNodes.add(node.left);
            }
            if (node.right != null) {
                nextNodes.add(node.right);
            }
            currentNodes = nextNodes;
            nextNodes = new ArrayList<>();
        }
        return root;
    }
}
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

