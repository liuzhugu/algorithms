//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 分治算法

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：面试题36:二叉搜索树与双向链表  后序遍历 2020/04/20
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
        //TO TEST
        solution.treeToDoublyList(stringToNode("[4,2,5,1,3]"));
    }
    public static Node stringToNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        Node root = new Node(Integer.parseInt(item));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new Node(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new Node(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            //得到头结点
            Node head = root;
            while (head.left != null) {
                head = head.left;
            }
            //得到尾节点
            Node tail = root;
            while (tail.right != null) {
                tail = tail.right;
            }
            //每个跟节点与前继节点和后继节点相互指向
            visit(root);
            //首跟尾建立联系
            head.left = tail;
            tail.right = head;
            return head;
        }
        private void visit (Node root) {
            //后续遍历
            //先遍历
            if (root.left != null) {
                visit(root.left);
            }
            if (root.right != null) {
                visit(root.right);
            }
            //后建立联系
            if (root.left != null) {
                Node predecessor = getPredecessor(root);
                predecessor.right = root;
                root.left = predecessor;
            }
            if (root.right != null) {
                Node successor = getSuccessor(root);
                successor.left = root;
                root.right = successor;
            }
        }
        //获取前继节点  左子树的最右节点
        private Node getPredecessor (Node node) {
            Node ans = node.left;
            while (ans != null && ans.right != null) {
                ans = ans.right;
            }
            return ans;
        }
        //获取后继节点  右子树的最左节点
        private Node getSuccessor (Node node) {
            Node ans = node.right;
            while (ans != null && ans.left != null) {
                ans = ans.left;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}