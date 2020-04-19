package leetcode.editor.cn;


import java.util.*;

/**
 * Created by liuzhugu on 2019/03/05.
 * 297. 二叉树的序列化与反序列化
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串
 * 并且将这个字符串反序列化为原始的树结构。
 * 记录:报错超时了,想不通
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        List<String> nodes = new ArrayList<>();
        //存储根节点
        searchTree(root,nodes);
        String result = nodes.toString();
        return result;
    }

//    private int findMaxHigh(TreeNode root,int maxHigh) {
//        int leftMaxHigh = maxHigh,rightMaxHigh = maxHigh;
//        if (root.left != null) {
//            leftMaxHigh = findMaxHigh(root.left,maxHigh + 1);
//        }
//        if (root.right != null) {
//            rightMaxHigh = findMaxHigh(root.right,maxHigh + 1);
//        }
//        return leftMaxHigh > rightMaxHigh ? leftMaxHigh : rightMaxHigh;
//    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        TreeNode root = null;
        data = data.replace("[","").replace("]","").replace(" ","");
        String[] nums = data.split(",");
        Queue<String> treeNodes = new ArrayDeque<>(Arrays.asList(nums));
        //深度优先来构建树
        return buildTree(treeNodes);
    }

    private void searchTree(TreeNode root,List<String> nodes){
        if (root == null) {
            nodes.add("$");
        }

        nodes.add(root.val+"");

        //存储左子树
        if (root.left != null) {
            nodes.add(root.left.val+"");
            searchTree(root.left,nodes);
        }

        //存储右子树
        if (root.right != null) {
            nodes.add(root.right.val+"");
            searchTree(root.right,nodes);
        }
    }

    //构建树
    private TreeNode buildTree(Queue<String> nodes) {
        if (nodes.size() == 0){
            return null;
        }
        String string = nodes.remove();
        if (string.equals("$")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(string));

        //构建左子树
        root.left = buildTree(nodes);

        //构建右子树
        root.right = buildTree(nodes);

        return root;
    }
}
