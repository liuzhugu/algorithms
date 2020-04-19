package leetcode.editor.cn;


/**
 * Created by liuzhugu on 2020/04/17.
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class CanJump {

    //不关心路线，只关心跳跃范围
    //某个位置可到达  那么它跃迁范围也可到达   最大的跃迁范围如果包含结尾 那么结尾也可到达
    public boolean canJump(int[] nums){
        int reach = 0,i = 0;
        //i小于等于reach  那么说明i可达
        while (i < nums.length && i <= reach) {
            //i抵达的地方都可达
            reach = Math.max(reach,nums[i] + i);
            i ++;
        }
        return reach >= nums.length - 1;
    }


//    public boolean canJump(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//        boolean[] canArrive = new boolean[nums.length];
//        canArrive[nums.length - 1] = true;
//        for (int i = nums.length - 2;i >= 0;i --) {
//            int step = nums[i];
//            step = (nums.length - 1) > (step + i) ? step + i : nums.length - 1;
//            for (int j = i;j <= step;j ++) {
//                if (canArrive[j] == true) {
//                    canArrive[i] = true;
//                    break;
//                }
//            }
//        }
//        return  canArrive[0];
//    }
}
