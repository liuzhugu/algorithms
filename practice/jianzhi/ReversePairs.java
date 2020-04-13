package practice.jianzhi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by liuzhugu on 2019/04/07.
 * 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        //建立数值与相应索引之前的关系
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).addFirst(i + 1);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i + 1);
                map.put(nums[i],list);
            }
        }
        //排序
        Arrays.sort(nums);
        //从大到小
        int ans = 0;
        KenTree kenTree = new KenTree(nums.length);
        for (int i = nums.length - 1;i >= 0;i --) {
            //无需理会与前值相等的数
            if (i + 1 <= nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            LinkedList<Integer> linkedList = map.get(nums[i]);
            for (int index : linkedList){
                //更新相应的个数统计和   对于树状数组来说  只关心最终的统计和
                //随着遍历过程  前n个数的和一直在变  具体到某个数都是 +1  所以我们遍历完之后只关心最终和就行
                kenTree.update(index,1);
                //把其之前的所有逆序对数加起来
                ans += kenTree.sum(index - 1);
            }
        }
        return ans;
    }

    //树状数组  根据特殊规则维护的数组
    //特点是求和简单  更新也简单
    class KenTree {
        int capacity;
        int[] elements;

        public KenTree(int capacity) {
            this.capacity = capacity;
            //0处不放值  因此索引范围是  1 -> capacity
            elements = new int[capacity + 1];
        }

        //求其二进制中1的最低位
        private int lowbit(int num) {
            return num & (- num);
        }

        //更新   index位置加上k  也就是在index每lowbit的位置都要加上k
        //因为这些位置的计算和的式子中包含elements[k]
        public void update(int index,int data) {
            //因为elements的每一个元素为其前n个元素之和
            //因此index位置加了data  那么与index有关的和都要加上data
            while (index < elements.length) {
                elements[index] += data;
                index += lowbit(index);
            }
        }

        //求和   同样的index位置的和  等于index位置加上之前与index每隔lowbit位置的总和
        public int sum(int index) {
            int ans = 0;
            //树状数组index位置总和  等于其前每少lowbit位置的总和
            while (index > 0) {
                ans += elements[index];
                index -= lowbit(index);
            }
            return ans;
        }

        //第k个数等于前k个数之和减去前k - 1个数之和
        public int get(int index) {
            return sum(index) - sum(index - 1);
        }
    }

    //超时
//    public int reversePairs(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int n = nums.length,ans = 0;
//        int[] newNums = new int[n];
//        for (int i = 0;i < n;i ++) {
//            newNums[i] = Integer.MAX_VALUE;
//        }
//        for (int i = n - 1;i >= 0;i --) {
//            //判断每个数在之后的数组中排多少 那么就有多少个逆序对
//            ans = ans + insert(newNums,nums[i]);
//        }
//        return ans;
//    }
//    private int insert(int[] nums,int num) {
//        for (int i = 0;i < nums.length;i ++) {
//            if (nums[i] == Integer.MAX_VALUE) {
//                nums[i] = num;
//                return i;
//            } else {
//                if (nums[i] < num) {
//                    continue;
//                } else {
//                    int index = i + 1;
//                    //往后移动  腾出空位
//                    while (index < nums.length - 1 || nums[index] != Integer.MAX_VALUE) {
//                        index ++;
//                    }
//                    while (index > i) {
//                        nums[index] = nums[index - 1];
//                        index --;
//                    }
//                    nums[i] = num;
//                    return i;
//                }
//            }
//        }
//        return nums.length - 1;
//    }
}
