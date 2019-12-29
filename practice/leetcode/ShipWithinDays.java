package practice.leetcode;

/**
 * Created by liuzhugu on 2019/12/29.
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。传送带上的第 i 个包裹的重量为 weights[i]。
 * 每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] A, int K) {
        int max = 0,sum = 0;
        for (int i : A) {
            if (i > max) {
                max = i;
            }
            sum = sum + i;
        }
        //二分搜索
        int left = max,right = sum,mid = (left + right) / 2;
        for (;left < right;) {
            mid = (left + right) / 2;
            if (canShip(A,mid,K)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    boolean canShip(int[] A,int weight,int day) {
        int curWeight = 0;
        for (int i = 0;i < A.length;i ++){
            curWeight = curWeight + A[i];
            if (curWeight >= weight) {
                if (curWeight == weight) {
                    curWeight = 0;
                }else {
                    curWeight = A[i];
                }
                day --;
            }
            if (day <= 0 && curWeight > 0) {
                return false;
            }
        }
        return true;
    }
}
