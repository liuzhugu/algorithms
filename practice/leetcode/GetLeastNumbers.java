package practice.leetcode;

import java.util.*;

/**
 * Created by liuzhugu on 2020/03/20.
 * 面试题40. 最小的k个数
 *  输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 *  则最小的4个数字是1、2、3、4。
 */
public class GetLeastNumbers {

    //快排的快速选择法

    //treemap的key有序   value记录次数来处理重复情况  那么久可以取前k的数了
    //优点是前k个数有序
    public int[] getLeastNumbers(int[] arr, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int[] result = new int[k];
        int index = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            for (int i = 0;(i < entry.getValue()) && (index < k);i ++) {
                result[index ++] = entry.getKey();
            }
        }
        return result;
    }

    //最小堆
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (arr == null || arr.length == 0) {
//            return new int[]{};
//        }
//        Queue<Integer> queue = new PriorityQueue<Integer>();
//        for (int i : arr) {
//            queue.add(i);
//        }
//        int[] result = new int[k];
//        for (int i = 0;i < k;i ++) {
//            result[i] = queue.poll();
//        }
//        return result;
//    }
}
