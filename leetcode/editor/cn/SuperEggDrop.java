package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2020/04/11.
 * 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少
 */
public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        results = new int[K + 1][N + 1];
        return dp(K, N);
    }
    private int[][] results;
    private int dp(int K,int N) {
        if (K == 0) {
            return 0;
        }
        if (K == 1) {
            return N;
        }
        if (results[K][N] != 0) {
            return results[K][N];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1;i <= N + 1;i ++) {
            //最少
            ans = Math.min(ans,
                    //最坏情况
                    Math.max(
                            //碎了 往下找
                            dp(K - 1,i - 1),
                            //没碎  往上找
                            dp(K,N - i)
                    ) + 1);
        }
        results[K][N] = ans;
        return ans;
    }
}
