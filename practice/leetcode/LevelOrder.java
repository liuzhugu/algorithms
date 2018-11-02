package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liuzhugu on 2018/5/6.
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值
 * 即逐层地，从左到右访问所有节点
 */
public class LevelOrder {
    public static void main(String[] args){
        TreeNode head=new TreeNode(3);
        TreeNode first=new TreeNode(9);
        TreeNode second=new TreeNode(20);
        TreeNode third=new TreeNode(1);
        TreeNode fourth=new TreeNode(15);
        TreeNode fifth=new TreeNode(7);
        TreeNode sixth=new TreeNode(3);

        head.left=first;
        head.right=second;
        first.left=third;
        second.left=fourth;
        second.right=fifth;
        third.left=sixth;
        LevelOrder test=new LevelOrder();

        System.out.println(test.maxDepth(head));
    }
    public int maxDepth(TreeNode root) {
        int currentDepth=0;
        return visit(root,currentDepth);
    }
    public int visit(TreeNode root,int currentDepth){
        if(root==null){
            return currentDepth;
        }
        int leftDepth=0,rightDepth=0;
        leftDepth=visit(root.left,currentDepth+1);
        rightDepth=visit(root.right,currentDepth+1);
        return leftDepth>rightDepth?leftDepth:rightDepth;

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        boolean isGoRight=false;
        Stack<TreeNode> currentLevelNode=new Stack<>();
        currentLevelNode.add(root);
        while(currentLevelNode!=null){
            List<Integer> currentLevelNum=new ArrayList<>();
            Stack<TreeNode> tmp=new Stack<>();
            while(!currentLevelNode.empty()){
                TreeNode node=currentLevelNode.pop();
                //input currentLevel
                currentLevelNum.add(node.val);
                //add nextLevel
                if(isGoRight){
                    if(node.left!=null){
                        tmp.push(node.left);
                    }
                    if(node.right!=null){
                        tmp.push(node.right);
                    }
                }else {
                    if (node.right != null) {
                        tmp.push(node.right);
                    }
                    if (node.left != null) {
                        tmp.push(node.left);
                    }
                }
            }
            result.add(currentLevelNum);
            if(isGoRight){
                isGoRight=false;
            }else{
                isGoRight=true;
            }
            if(tmp.size()!=0){
                currentLevelNode=tmp;
            }else {
                currentLevelNode=null;
            }
        }
        return result;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        List<TreeNode> currentLevelNode=new ArrayList<>();
        currentLevelNode.add(root);
        while(currentLevelNode!=null){
            List<Integer> currentLevelNum=new ArrayList<>();
            List<TreeNode> tmp=new ArrayList<>();
            int index=0;
            while(index!=currentLevelNode.size()){
                TreeNode node=currentLevelNode.get(index);
                //input currentLevel
                currentLevelNum.add(node.val);
                //add nextLevel
                if(node.left!=null){
                    tmp.add(node.left);
                }
                if(node.right!=null){
                    tmp.add(node.right);
                }
                index++;
            }
            result.add(currentLevelNum);
            if(tmp.size()!=0){
                currentLevelNode=tmp;
            }else {
                currentLevelNode=null;
            }
        }
        List<List<Integer>> reverResult=new ArrayList<>();
        for(int i=result.size()-1;i>=0;i--){
            reverResult.add(result.get(i));
        }
        return result;
    }
}
