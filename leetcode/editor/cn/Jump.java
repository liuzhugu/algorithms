package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2020/04/17.
 * 45. 跳跃游戏 II
 *  给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class Jump {
    public int jump(int[] nums) {
        int step = 0,index = 0;
        while (index < nums.length - 1) {
            //当前节点能抵达结尾
            if (nums[index] + index >= nums.length - 1) {
                return step + 1;
            }
            int end = (nums.length - 1) > (nums[index] + index) ? nums[index] + index : nums.length - 1;
            int max = index;
            for (int i = index + 1;i <= end;i ++) {
                int nextStep =  nums[i] + i;
                //下一个节点能抵达
                if (nextStep >= nums.length - 1) {
                    return step + 2;
                }
                if (max < nextStep) {
                    max = nextStep;
                    index = i;
                }
            }
            step ++;
        }
        return step;
    }
    //最少   dp  超时
//    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        for (int i = 0;i < nums.length;i ++) {
//            if (i == 0) {
//                dp[i] = 0;
//            } else {
//                //可抵达该点的地方
//                Set<Integer> set = map.get(i);
//                dp[i] = 100000;
//                if (set != null) {
//                    for (int index : set) {
//                        dp[i] = Math.min(dp[i],dp[index]);
//                    }
//                }
//                dp[i] ++;
//            }
//            //该点可抵达的地方
//            int end = (nums.length - 1) > (nums[i] + i) ? nums[i] + i : nums.length - 1;
//            for (int j = i + 1;j <= end;j ++) {
//                Set<Integer> set = map.get(j);
//                if (set == null) {
//                    set = new HashSet<>();
//                    map.put(j,set);
//                }
//                set.add(i);
//            }
//        }
//        return dp[nums.length - 1];
//    }
}
