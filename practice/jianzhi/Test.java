package practice.jianzhi;

import practice.leetcode.CanThreePartsEqualSum;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
//        ReverseWords reverseWords = new ReverseWords();
//        System.out.println(reverseWords.reverseWords("the sky is blue!"));

//        CQueue cQueue = new CQueue();
//        cQueue.appendTail(3);
//        cQueue.appendTail(4);
//        System.out.println(cQueue.deleteHead());
//        cQueue.appendTail(5);
//        cQueue.appendTail(6);
//        System.out.println(cQueue.deleteHead());
//        System.out.println(cQueue.deleteHead());

        //FirstUniqChar firstUniqChar = new FirstUniqChar();
        //System.out.println(firstUniqChar.firstUniqChar("leecode"));

        //SingleNumbers singleNumbers = new SingleNumbers();
        //System.out.println(singleNumbers.singleNumbers(new int[]{4,1,4,6}));

        //HammingWeight hammingWeight = new HammingWeight();
        //System.out.println(hammingWeight.hammingWeight(1));

        //MinArray minArray = new MinArray();
        //System.out.println(minArray.minArray(new int[]{1,3,3}));

//        Codec codec = new Codec();
//        TreeNode treeNode = codec.deserialize("[]");
//        System.out.println(codec.serialize(treeNode));

        //BuildTree buildTree = new BuildTree();
        //buildTree.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});

//        Node node1 = new Node(7);
//        Node node2 = new Node(13);
//        Node node3 = new Node(11);
//        Node node4 = new Node(10);
//        Node node5 = new Node(1);
//        node2.random = node1;
//        node3.random = node5;
//        node4.random = node3;
//        node5.random = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        CopyRandomList copyRandomList = new CopyRandomList();
//        copyRandomList.copyRandomList(node1);

        //CanThreePartsEqualSum canThreePartsEqualSum = new CanThreePartsEqualSum();
        //System.out.println(canThreePartsEqualSum.canThreePartsEqualSum(new int[]{1,-1,1,-1}));

        //NthUglyNumber nthUglyNumber = new NthUglyNumber();
        //System.out.println(nthUglyNumber.nthUglyNumber(10));

        //NumWays numWays = new NumWays();
        //System.out.println(numWays.numWays(100));

        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(stringToTreeNode("[2,3,3,4,5,5,4,null,null,8,9,9,8]")));
    }
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
