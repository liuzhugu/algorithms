package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/03/24。
 * 面试题 17.16. 按摩师
 *  一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
 *  因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），
 *  返回总的分钟数。
 */
public class Massage {

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //双dp替代回溯法
        int[] dpSelect = new int[nums.length + 1];
        int[] dpNoSelect = new int[nums.length + 1];
        dpNoSelect[0] = 0;
        dpSelect[0] = 0;
        for (int i = 1;i <= nums.length;i ++) {
            dpNoSelect[i] = Math.max(dpNoSelect[i - 1],dpSelect[i - 1]);
            dpSelect[i] = dpNoSelect[i - 1] + nums[i - 1];
        }
        return dpSelect[nums.length] > dpNoSelect[nums.length] ? dpSelect[nums.length] :
                dpNoSelect[nums.length];
    }

    //超时
//    public int massage(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        find(nums,0,false,0);
//        return max;
//    }
//
//    private int max = 0;
//    private void find(int[] nums,int i,boolean pre,int sum) {
//        if (i == nums.length) {
//            if (sum > max) {
//                max = sum;
//            }
//            return;
//        }
//        if (pre) {
//            //不选择当前数
//            find(nums,i + 1,false,sum);
//            return;
//        }
//        //选择当前数
//        find(nums,i + 1,true,sum + nums[i]);
//        //不选择当前数
//        find(nums,i + 1,false,sum);
//    }
}
