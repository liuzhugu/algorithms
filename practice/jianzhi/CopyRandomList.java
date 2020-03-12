package practice.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhugu on 2020/03/10.
 * 面试题35. 复杂链表的复制
 *  请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 *  还有一个 random 指针指向链表中的任意节点或者 null。
 *
*/
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //空间换时间   通过额外map  完成原链表到复制链表的关系转移
        Map<Node,Node> map = new HashMap<>();
        Map<Node,Node> relationMap = new HashMap<>();
        Node newHead = null,currentNode = head,preNode = null;
        while (currentNode != null) {
            Node newNode = new Node(currentNode.val);
            if (newHead == null) {
                newHead = newNode;
                preNode = newHead;
            } else {
                preNode.next = newNode;
                preNode = preNode.next;
            }
            //保存任意连接关系
            if (currentNode.random != null) {
                map.put(currentNode,currentNode.random);
            }
            relationMap.put(currentNode,newNode);
            //保存原节点和复制节点之间的关系
            currentNode = currentNode.next;
        }
        //根据原链表的任意关系设置新链表的任意关系
        for (Map.Entry<Node,Node> entry : map.entrySet()) {
            relationMap.get(entry.getKey()).random = relationMap.get(entry.getValue());
        }
        return newHead;
    }
}
