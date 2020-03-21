package practice.leetcode;

/**
 * Created by liuzhugu on 2020/03/22.
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 *      装满任意一个水壶
 *      清空任意一个水壶
 *      从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        //如果两个水壶都装满水还是满足不了的话  那么肯定不行了
        if (x + y < z) return false;
        if (x == 0 || y == 0) {
            //如果有个水壶用不了  那么要么不装水 要么其中一个装满水
            return z == 0 || x + y == z;
        }
        //如果z是x和y的最大公约数的倍数  那么有a和b
        //使得ax + by = z 因为d的倍数加上d的倍数结果还是d的倍数
        return z % gcd(x,y) == 0;
    }

    private int gcd(int x,int y) {
        return x % y == 0 ? y : gcd(y,x % y);
    }
}
