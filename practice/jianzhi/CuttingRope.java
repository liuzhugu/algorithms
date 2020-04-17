package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/04/17.
 * 面试题14- I.和 II 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CuttingRope {

    //需要取模
    public int cuttingRope(int n) {
        int end = n / 3 >= 2 ? (n + 1) / 3 : 2;
        int ans = 0;
        int remainder = n % end;
        int quotient = n / end;
        int num = end;
        long product = 1;
        int mod = (int)1e9+7;
        while (num > 0) {
            if (remainder != 0) {
                product = product * (quotient + 1) % mod;
                remainder --;
            } else {
                product = product * quotient % mod;
            }
            num --;
        }
        if (product > ans) {
            ans = (int)product;
        }
        return ans;
    }


//    public int cuttingRope(int n) {
//        int end = n / 3 >= 2 ? (n + 1) / 3 : 2;
//        int ans = 0;
//        for (int i = 2;i <= end;i ++) {
//            int remainder = n % i;
//            int quotient = n / i;
//            int num = i;
//            int product = 1;
//            while (num > 0) {
//                if (remainder != 0) {
//                    product = product * (quotient + 1);
//                    remainder --;
//                } else {
//                    product = product * quotient ;
//                }
//                num --;
//            }
//            if (product > ans) {
//                ans = product;
//            }
//        }
//        return ans;
//    }
}
