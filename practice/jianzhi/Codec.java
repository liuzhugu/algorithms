package practice.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2020/03/09.
 * 面试题37. 序列化二叉树
 *  请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        //广度遍历
        List<TreeNode> currentLevel = new ArrayList<>();
        StringBuilder result = new StringBuilder("[" + root.val);
        currentLevel.add(root);
        while (! currentLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            for (TreeNode node : currentLevel) {
                //左子树
                if (node.left == null) {
                    str.append(",null" );
                } else {
                    nextLevel.add(node.left);
                    str.append("," + node.left.val);
                }
                //右子树
                if (node.right == null) {
                    str.append(",null" );
                } else {
                    nextLevel.add(node.right);
                    str.append("," + node.right.val);
                }
            }
            if (! nextLevel.isEmpty()) {
                result.append(str.toString());
            }
            currentLevel = nextLevel;
        }
        result.append("]");
        return result.toString();
    }

    public TreeNode deserialize(String data) {
        String[] strings = data.substring(1,data.length() - 1).split(",");
        TreeNode nullNode = new TreeNode(0);
        List<TreeNode> nodeList = new ArrayList<>();
        for (String str : strings) {
            if (! str.equals("")) {
                if (str.equals("null")) {
                    nodeList.add(nullNode);
                } else {
                    nodeList.add(new TreeNode(Integer.parseInt(str)));
                }
            }
        }
        if (nodeList.isEmpty()) return null;
        List<Integer> currentLevel = new ArrayList<>();
        currentLevel.add(0);
        while (! currentLevel.isEmpty()) {
            List<Integer> nextLevel = new ArrayList<>();
            int size = 0;
            for (int i = 0;i < currentLevel.size();i ++) {
                int index = currentLevel.get(i);
                if (index != -1) {
                    TreeNode node = nodeList.get(index);
                    //左子树
                    int left = index + currentLevel.size() - i + size * 2;
                    if (left < nodeList.size()) {
                        if (nodeList.get(left) == nullNode) {
                            node.left = null;
                            nextLevel.add(-1);
                        } else {
                            node.left = nodeList.get(left);
                            nextLevel.add(left);
                        }
                    }
                    //右子树
                    int right = left + 1;
                    if (right < nodeList.size()) {
                        if (nodeList.get(right) == nullNode) {
                            node.right = null;
                            nextLevel.add(-1);
                        } else {
                            node.right = nodeList.get(right);
                            nextLevel.add(right);
                        }
                    }
                    size ++;
                }
            }
            currentLevel = nextLevel;
        }
        return nodeList.isEmpty() ? null : nodeList.get(0);
    }
}
