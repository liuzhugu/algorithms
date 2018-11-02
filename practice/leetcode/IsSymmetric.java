package practice.leetcode;

import java.util.Stack;

/**
 * Created by liuzhugu on 2018/5/6.
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        if(root.left==null||root.right==null){
            return false;
        }

        Stack<TreeNode> leftNodes =new Stack<>();
        Stack<TreeNode> rightNodes =new Stack<>();
        leftNodes.push(root.left);
        rightNodes.push(root.right);

        while(!leftNodes.empty()||!rightNodes.empty()){
            TreeNode leftNode=leftNodes.pop();
            TreeNode rightNode=rightNodes.pop();
            if(leftNode.val!=rightNode.val){
                return false;
            }

            //judge left
            if(leftNode.left!=null&&rightNode.right!=null){
                leftNodes.push(leftNode.left);
                rightNodes.push(rightNode.right);
            }else if(leftNode.left==null&&rightNode.right==null){

            }else{
                return false;
            }

            //judge right
            if(leftNode.right!=null&&rightNode.left!=null){
                leftNodes.push(leftNode.right);
                rightNodes.push(rightNode.left);
            }else if(leftNode.right==null&&rightNode.left==null){

            }else{
                return false;
            }
        }
        return true;
    }
}
