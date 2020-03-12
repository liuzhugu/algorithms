package practice.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2020/03/10.
 * 面试题07. 重建二叉树
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 *  假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        for (int i = 0;i < inorder.length;i ++) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }
    private Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder,int preLeft,int preRight, int[] inorder,int inLeft,int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        if (preLeft == preRight && inLeft == inRight) {
            return new TreeNode(preorder[preLeft]);
        }
        //找出根节点和子节点  递归构造
        TreeNode root = new TreeNode(preorder[preLeft]);
        //根据跟节点的值找出其在中序序列中的index  这要求树的值没有重复的
        int  childInLeft = inLeft,childInRight = map.get(root.val);
        int childPreLeft = preLeft + 1,childPreRight = childPreLeft + childInRight - childInLeft;
        root.left = buildTree(preorder,childPreLeft,childPreRight - 1,inorder,childInLeft,childInRight - 1);
        root.right = buildTree(preorder,childPreRight,preRight,inorder,childInRight + 1,inRight);
        return root;
    }
}
