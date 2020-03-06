package practice.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        while (! nodeList.isEmpty()) {
            List<TreeNode> nextList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            int index = 0;
            while (index < nodeList.size()) {
                TreeNode node = nodeList.get(index ++);
                list.add(node.val);
                if (node.left != null) {
                    nextList.add(node.left);
                }
                if (node.right != null) {
                    nextList.add(node.right);
                }
            }
            result.add(list);
            nodeList.clear();
            nodeList = nextList;
        }
        return result;
    }
}
