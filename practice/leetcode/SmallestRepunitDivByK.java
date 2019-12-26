package practice.leetcode;

public class SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int x = 1;
        int len = 1;
        while (x % K != 0) {
            x = (x % K) * 10 + 1;
            len ++;
        }
        return len;
    }
}
