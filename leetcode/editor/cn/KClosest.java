package leetcode.editor.cn;

import struct.Heap;

import java.util.*;

/**
 * Created by liuzhugu on 2019/03/27.
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length ==0 || K == 0) {
            return new int[][]{};
        }
        if (points.length <= K){
            return points;
        }
        //距离的最小堆,然后从最小堆取距离前k,然后找到这些距离对应的点
        Heap heap = new Heap(false);
        //key是距离的平方,value是相应的index列表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i < points.length;i ++) {
            int[] point = points[i];
            int distance = point[0] * point[0] + point[1] * point[1];
            heap.add(distance);
            List<Integer> indexs;
            if (map.get(distance) == null) {
                indexs = new ArrayList<>();
                indexs.add(i);
                map.put(distance,indexs);
            }else {
                indexs = map.get(distance);
                indexs.add(i);
            }
        }
        int[] distances = new int[K];
        for (int i = 0;i < K;i ++) {
            distances[i] = heap.poll();
        }
        int[][] result = new int[K][2];
        int i = 0,j = 0;
        while (i < K && j < distances.length) {
            List<Integer> indexs = map.get(distances[j ++]);
            for (int k = 0;k < indexs.size();k ++) {
                if (i < K) {
                    result[i] = points[indexs.get(k)];
                    i ++;
                }
            }
        }
        return result;
    }
}
