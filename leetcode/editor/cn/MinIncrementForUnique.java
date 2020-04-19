package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2020/03/22.
 * 945. 使数组唯一的最小增量
 *  给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 */
public class MinIncrementForUnique {

    //用空间换效率   如果要省空间  还是map的按需存储好点
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        int result = 0;
        if (A == null || A.length == 0) {
            return result;
        }
        int min = Integer.MAX_VALUE;
        for (int i : A) {
            if (min > i) {
                min = i;
            }
            count[i] ++;
        }
        int index = A.length,num = 0;
        for (int i = min;i < 80000;i ++) {
            if (index > 0) {
                if (count[i] == 0) {
                    if (num != 0) {
                        num --;
                        //移动所需步骤需要加后减后   但知前时不知后 因此可以把操作分开来
                        //碰到前时减去  碰到后时减去
                        result = result + i;
                    }
                } else {
                    num = num + count[i] - 1;
                    result = result - (count[i] - 1) * i;
                    index --;
                }
            } else {
                break;
            }
        }
        return result;
    }

    //超时  虽然节省空间 但后期为维护这个set以及在这个set中进行查找效率变低
//    public int minIncrementForUnique(int[] A) {
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//        Set<Integer> nums = new HashSet<>();
//        Map<Integer,Integer> map = new TreeMap<>();
//        for (int i : A) {
//            map.put(i,map.getOrDefault(i,0) + 1);
//            nums.add(i);
//        }
//        int result = 0;
//        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
//              int index = 1,count = entry.getValue();
//              while (count != 1) {
//                  int num = entry.getKey() + index;
//                  //移位
//                  if (! nums.contains(num)) {
//                      nums.add(num);
//                      count --;
//                      result = result + index;
//                      index = 1;
//                  }
//                  index ++;
//              }
//        }
//        return result;
//    }
}
