package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/07.
 * 面试题33. 二叉搜索树的后序遍历序列
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 *  假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        //序列最后一位是根节点  前半部分是根的左子树  除了根节点的后半部分是根的右子树
        //递归判断
        return verify(postorder,0,postorder.length);
    }
    private boolean verify(int[] postorder,int start,int end) {
        if (start >= end) return true;
        int rootValue = postorder[end];
        int index = start;
        //找左子树
        while (index < end && postorder[index] < rootValue) {
            index ++;
        }
        int separate;
        //找右子树
        if (index < end) {
            separate = index;
            while (index < end) {
                if (postorder[index] < rootValue) {
                    return false;
                }
                index ++;
            }
            return verify(postorder,start,separate) && verify(postorder,separate + 1,end - 1);
        } else {
            return verify(postorder,start,end - 1);
        }
    }
}
