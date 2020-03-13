package practice.leetcode;

/**
 * Created by liuzhugu on 2020/03/11.
 * 1013. 将数组分成和相等的三个部分
 *  给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] ==
 * A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 */
public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0;i < A.length;i ++) {
            sum = sum + A[i];
        }
        //不能整除3
        if (sum % 3 != 0) return false;
        boolean first = false,second = false;
        int cunrrentSum = 0;
        for (int i = 0;i < A.length;i ++) {
            cunrrentSum = cunrrentSum + A[i];
            if (first) {
                if (cunrrentSum == (sum / 3 * 2) && (i < A.length - 1)){
                    second = true;
                }
            }
            if (cunrrentSum == (sum / 3)){
                first = true;
            }
        }
        return first && second;
    }
}
