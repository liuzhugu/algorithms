//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：297:二叉树的序列化与反序列化  2020/04/19
public class SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTree().new Codec();
        //TO TEST 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    //leetcode submit region end(Prohibit modification and deletion)

}