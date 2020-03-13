package practice.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2020/03/12.
 * 面试题28. 对称的二叉树
 *  请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class IsSymmetric {

    //递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        //一边为空一边不为
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left.val != right.val) return false;
        //对称比较
        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

    //广度遍历
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        //广度遍历
//        if ((root.left != null && root.right == null) ||
//                (root.left == null && root.right != null)) {
//            return false;
//        }
//        if (root.left == null && root.right == null) return true;
//        //左右子树节点
//        List<TreeNode> left = new ArrayList<>();
//        left.add(root.left);
//        List<TreeNode> right = new ArrayList<>();
//        right.add(root.right);
//        while ( ! left.isEmpty() && ! right.isEmpty()) {
//            List<TreeNode> nextLeft = new ArrayList<>();
//            List<TreeNode> nextRight = new ArrayList<>();
//            //数目不等
//            if (left.size() != right.size()) {
//                return false;
//            }
//            int leftCount = 0,rightCount = 0;
//            //对称比较
//            for (int i = 0;i < left.size();i ++) {
//                TreeNode leftNode = left.get(i);
//                TreeNode rightNode = right.get(left.size() - i - 1);
//                //值不等
//                if (leftNode.val != rightNode.val) return false;
//            }
//            //顺序添加
//            for (int i = 0;i < left.size();i ++) {
//                TreeNode leftNode = left.get(i);
//                TreeNode rightNode = right.get(i);
//
//                //左
//                if (leftNode.left != null) {
//                    leftCount ++;
//                    nextLeft.add(leftNode.left);
//                } else {
//                    nextLeft.add(new TreeNode(-1));
//                }
//                if (leftNode.right != null) {
//                    leftCount ++;
//                    nextLeft.add(leftNode.right);
//                } else {
//                    nextLeft.add(new TreeNode(-1));
//                }
//                //右
//                if (rightNode.left != null) {
//                    rightCount ++;
//                    nextRight.add(rightNode.left);
//                } else {
//                    nextRight.add(new TreeNode(-1));
//                }
//                if (rightNode.right != null) {
//                    rightCount ++;
//                    nextRight.add(rightNode.right);
//                } else {
//                    nextRight.add(new TreeNode(-1));
//                }
//            }
//            if (leftCount == 0 && rightCount == 0) break;
//            left = nextLeft;
//            right = nextRight;
//        }
//        return true;
//    }
}
