package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Created by liuzhugu on 2019/11/24.
 * 658. 找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        //按照距离排个序
        Collections.sort(list, (a,b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b-x));
        list = list.subList(0,k);
        Collections.sort(list);
        return list;
    }
}
