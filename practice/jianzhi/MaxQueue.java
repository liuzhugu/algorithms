package practice.jianzhi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by liuzhugu on 2020/03/07.
 * 面试题59 - II. 队列的最大值
 *  请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和
 *  pop_front 的时间复杂度都是O(1)。若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class MaxQueue {
    //因为要求队尾队列添加和弹出是O(1)  因此用链表来
    private ListNode head,tail;
    //因为后进前出  所以双端队列
    Deque<ListNode> deque = new LinkedList();

    public MaxQueue() {
        head = head = null;
    }

    public int max_value() {
        if (deque.isEmpty()) return -1;
        return deque.getFirst().value;
    }

    public void push_back(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        //删掉非可能最大值
        while (! deque.isEmpty() && deque.getLast().value < value) {
            deque.removeLast();
        }
        deque.add(newNode);
    }

    public int pop_front() {
        if (head == null) return -1;
        ListNode result = head;
        head = head.next;
        if (head == null) {
            tail = head = null;
        }
        //最大值被弹出
        if (result == deque.getFirst()) {
            deque.removeFirst();
        }
        return result.value;
    }
}
class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
        this.value = value;
    }
}
