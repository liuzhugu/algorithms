package leetcode.editor.cn;

public class IsBipartite {
    //并查集
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] dp = new int[2 * N + 5];
        for (int i = 0;i < 2 * N + 5;i ++) {
            //赋初始值
            dp[i] = i;
        }
        for (int i = 0;i < N;i ++) {
            int[] nums = graph[i];
            for (int num : nums) {
                //找其根节点
                int a = findParent(i,dp);
                int b = findParent(num,dp);
                //找其非同一集合的根节点
                int x = findParent(i + N,dp);
                int y = findParent(num + N,dp);
                if (a == b) {
                    //该边的两点在同一集合中
                    return false;
                }else {
                    //相互非同一集合的话,扩展各自的非同一集合
                    dp[x] = b;
                    dp[y] = a;
                }
            }
        }
        return true;
    }
    public int findParent(int k,int[] arr){
        if (arr[k] != k) {
            return findParent(arr[k],arr);
        }
        return arr[k];
    }
}
