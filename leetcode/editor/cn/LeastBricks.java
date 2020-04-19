package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null) {
            return 0;
        }
        int n = wall.size();
        Map<Integer,Integer> map = new HashMap<>();
        //存有墙的位置太耗内存,缝的位置远少于墙,所以存墙的位置
        for (List<Integer> list : wall) {
            int sum = 0;
            //不考虑最后一个  因为最后一块砖之后的缝不考虑
            for (int i = 0;i < list.size() - 1;i ++) {
                int num = list.get(i);
                sum = sum + num;
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }
        //找出缝最多的位置,那么n - count就是该位置有几块砖
        int max = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return n - max;
    }


    //超内存限制了
//    public int leastBricks(List<List<Integer>> wall) {
//        if (wall == null) {
//            return 0;
//        }
//        int sum = 0;
//        List<Integer> first = wall.get(0);
//        for (int i : first) {
//            sum = sum + i;
//        }
//        int maxSize = 0;
//        int[] map = new int[sum + 1];
//        for (List<Integer> list : wall) {
//            if (list.size() > maxSize) {
//                maxSize = list.size();
//            }
//            if (list.size() == 1) {
//                map[1] ++;
//            }else {
//                int index = 0;
//                for (int i : list) {
//                    int j = index + 1;
//                    for (;j < index + i;j ++) {
//                        map[j] = map[j] + 1;
//                    }
//                    index = j;
//                }
//            }
//        }
//        //取最小
//        int result = Integer.MAX_VALUE;
//        if (maxSize == 1) {
//            return map[1];
//        }else {
//            for (int i = 1;i < sum;i ++) {
//                if (map[i] < result) {
//                    result = map[i];
//                }
//            }
//            return result;
//        }
//    }
}
