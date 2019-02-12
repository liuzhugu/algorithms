package algorithms.stringmatch;

/**
 * 坏字符:
 *  我们把坏字符对应的模式串中的字符下标记作si。如果坏字符在模式串中存在，我们把这个坏字符
 *  在模式串中的下标xi。如果不存在，我们把xi记作-1。那模式串往后移动的位数就等于si-xi
 * 好后缀:
 *
 *
 * */
public class BM {
    private static final int SIZE=256;

    private void generateBC(String b,int m,int[] bc){
        for(int i=0;i<SIZE;i++){
            bc[i]=-1;
        }
        for(int i=0;i<m;i++){
            int ascii=(int)b.charAt(i);//计算 b[i] 的 ASCII 值,保存的是最后一个,前面出现的顺序会被覆盖
            bc[ascii]=i;
        }
    }

    public int match(String  main,String match){
        int[] bc=new int[SIZE];// 记录模式串中每个字符最后出现的位置
        generateBC(match,match.length(),bc);// 构建坏字符哈希表
        int i=0;
        while(i<main.length()-match.length()){
            int j;
            for(j=match.length();j>=0;j--){
                if(main.charAt(i+j)!=match.charAt(j)){
                    break;
                }
            }
            if(j<0){
                return i;
            }
            i=i+(j-bc[(int)match.charAt(i+j)]);
        }
        return -1;
    }

}
