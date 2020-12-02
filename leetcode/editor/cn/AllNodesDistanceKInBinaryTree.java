//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 198 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：863:二叉树中所有距离为 K 的结点
public class AllNodesDistanceKInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> ans;
        TreeNode target;
        int K;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            ans = new ArrayList<>();
            this.target = target;
            this.K = K;
            dfs(root);
            return ans;
        }

        //subTree的距离是从目标节点往下探
        //dfs的的返回距离是从目标节点往回退出递归的时候往上带

        //返回结果为距离target的距离 没找到target的话为-1
        public int dfs(TreeNode node) {
            //终止条件
            if (node == null) {
                return -1;
            }
            //找到目标
            else if (node == target) {
                //往下找距离为K的点
                subTree(node, 0);
                return 1;
            }
            //找不到继续递归找
            else {
                int L = dfs(node.left), R = dfs(node.right);

                //判断在子树中是否找到
                if (L != -1) {
                    //如果找到的话看当前节点与target之间的距离
                    if (L == K) {
                        ans.add(node.val);
                    }
                    // 然后再看另外一个子树是否有符合目标的点
                    subTree(node.right, L + 1);
                    return L + 1;
                } else if (R != -1) {
                    //同理
                    if (R == K) {
                        ans.add(node.val);
                    }
                    subTree(node.left, R + 1);
                    return R + 1;
                } else {
                    return -1;
                }
            }
        }

        //找到目标之后开始数距离
        public void subTree(TreeNode node, int dist) {
            if (node == null) return;
            if (dist == K) {
                ans.add(node.val);
            } else {
                subTree(node.left, dist + 1);
                subTree(node.right, dist + 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    }