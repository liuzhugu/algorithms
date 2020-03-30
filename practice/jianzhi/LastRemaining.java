package practice.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2020/03/30。
 * 面试题62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是
 * 2、0、4、1，因此最后剩下的数字是3。
 */
public class LastRemaining {

    //逆向思维
    public int lastRemaining(int n, int m) {
       //从最后情况往回推
        int ans = 0;
        for (int i = 2;i < n;i ++) {
            ans = (ans + m) % i;
        }
        return ans;
    }


    //链表会超时是因为要找下一个数字需要m  而数组删除数字需要n
    //因为m比n打一个量级   所以 n * m远大于 n * n
//    public int lastRemaining(int n, int m) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0;i < n;i ++) {
//            list.add(i);
//        }
//        int index = 0;
//        //数组的大小在不断减小
//        while (n > 1) {
//            //因为删除了一个数字 所以要减1  回退一位
//            index = (index + m - 1) % n;
//            list.remove(index);
//            n --;
//        }
//        return list.get(0);
//    }

    //超时
//    public int lastRemaining(int n, int m) {
//        Node head = buildNode(n);
//        Node tail = head;
//        //找到结尾
//        while (tail.next != null) {
//            tail = tail.next;
//        }
//        Node cunrrentNode = head,preNode = null;
//        while (tail != head) {
//            int count = m - 1;
//            while (count != 0) {
//                //步进
//                preNode = cunrrentNode;
//                //到了结尾  从新回到开头
//                if (cunrrentNode == tail) {
//                    cunrrentNode = head;
//                } else {
//                    cunrrentNode = cunrrentNode.next;
//                }
//                count --;
//            }
//            //找到节点 删除节点
//            if (cunrrentNode == head) {
//                head = head.next;
//                cunrrentNode.next = null;
//                cunrrentNode = head;
//            } else if (cunrrentNode == tail) {
//                tail = preNode;
//                preNode.next = null;
//                cunrrentNode = head;
//            } else {
//                preNode.next = cunrrentNode.next;
//                cunrrentNode.next = null;
//                cunrrentNode = preNode.next;
//            }
//        }
//        return head.val;
//    }
//    private Node buildNode(int n) {
//        Node head = null,preNode = null;
//        for (int i = 0;i < n;i ++) {
//            Node node = new Node(i);
//            if (head == null) {
//                head = node;
//                preNode = node;
//            } else {
//                preNode.next = node;
//                preNode = node;
//            }
//        }
//        return head;
//    }
//    class Node {
//        public int val;
//        public Node next;
//        public Node(int val) {
//            this.val = val;
//        }
//    }
}
