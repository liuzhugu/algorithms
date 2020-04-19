package leetcode.editor.cn;

import struct.Heap;

/**
 * Created by liuzhugu on 2019/03/12.
 * 907. 子数组的最小值之和
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是
 * 节点编号的奇偶性，而不是节点的值的奇偶性。请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)
 * 时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class SumSubarrayMins {
    public int sumSubarrayMins(int[] A) {
        int sum = 0;
        int n = A.length;
        for (int i = 1;i <= n;i ++) {
            //最小堆
            Heap heap = new Heap(false);
            for (int j = 0;j < n;j ++) {
                heap.add(A[j]);
                //放够之后开始获取最小值
                if (heap.size() == i){
                    sum = sum + heap.peek();
                    heap.remove(A[j - i + 1]);
                }
            }
        }
        return sum % 1000000007;
    }

}
