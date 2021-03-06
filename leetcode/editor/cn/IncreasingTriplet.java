package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2019/03/13.
 * 334. 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * 注:i,j,k不要求连续
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int minest = Integer.MIN_VALUE,minner = Integer.MIN_VALUE;
        int preMinner = minner,preMinest = minest;
        int i =0, shouldSkip = Integer.MIN_VALUE;
        while (true) {
            for (;i < nums.length;i ++) {
                if (minner == Integer.MIN_VALUE) {
                    if (minest == Integer.MIN_VALUE) {
                        minner = nums[i];
                    }else {
                        if (minest < nums[i]) {
                            minner = nums[i];
                        }else if (minest > nums[i]) {
                            minest = nums[i];
                        }
                    }
                    continue;
                }
                if (minest == Integer.MIN_VALUE) {
                    if (minner > nums[i]) {
                        minner = nums[i];
                    }else if (minner < nums[i]){
                        minest = minner;
                        minner = nums[i];
                    }
                    continue;
                }
                if (nums[i] > minner) {
                    return true;
                }else if (nums[i] < minner) {
                    if (nums[i] > minest) {
                        minner = nums[i];
                    }else if (nums[i] < minest){
                        //保存下此时的最小值和次小值便于回退
                        preMinner = minner;
                        preMinest = minest;
                        minest = nums[i];
                        minner = Integer.MIN_VALUE;
                        //此时minner为空,如果到结尾还是为minner找不到值的话,那么应该回退到这里,然后跳过该值然后继续
                        shouldSkip = i;
                    }
                }
            }
            //如果还是找不到的话回退并且之后跳过该值
            if (shouldSkip != Integer.MIN_VALUE) {
                //执行回退
                i = shouldSkip + 1;
                shouldSkip = Integer.MIN_VALUE;
                minner = preMinner;
                minest = preMinest;
            }else {
                break;
            }

        }
        return false;
    }
}
