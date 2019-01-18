package algorithms.za;

/**
 * 求中值
 * */
import java.util.Random;

public class Test {

    public static void main(String[] args){
        Median median=new Median();
        Random random=new Random();
        for(int i=0;i<20;i++){
            int value=random.nextInt(100);
            System.out.print("要加入的值为:"+value+" 加入之后为:");
            median.add(value);
            median.print();
            System.out.println();
        }
    }
}
