package practice.study;


/**
 * 给定一组数据，比如 1，3，5，6，9，10 可以构建多少种不同的二叉树
 * */
public class FindTreeCount {

    //只需要知道数目
    public static int find(int n){
        if(n<=0){return 0;}
        int[] count=new int[n+1];
        count[0]=1;
        count[1]=1;
        for(int i=1;i<=n;i++){
            int sum=0;
            for(int j=1;j<=i;j++){
                sum+=count[j-1]*count[i-j];
            }
            count[i]=sum;
        }
        return count[n];
    }
}
