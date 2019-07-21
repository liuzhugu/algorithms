package practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuzhugu on 2019/07/21.
 * 781. 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
 * 我们将这些回答放在 answers 数组里。返回森林中兔子的最少数量。
 **/

public class NumRabbits {
    public int numRabbits(int[] answers) {
        int result = 0;
        //因为是求最少,那么回答一样数目的那么也得是同样的颜色,所以去重就行
        HashMap<Integer,Integer> numSum = new HashMap<>();
        for (int i = 0;i < answers.length;i ++) {
            //而0说明没有相同的因此要单独加
            int num = answers[i];
            if (num == 0) {
                result ++;
            }else {
                if (numSum.containsKey(num)) {
                    numSum.put(num,numSum.get(num) + 1);
                }else {
                    numSum.put(num,1);
                }
            }
        }
        for (Map.Entry<Integer,Integer> entry : numSum.entrySet()) {
            int num = entry.getKey(),sum = entry.getValue();
            do{
                result = result + num + 1;
                sum = sum - num - 1;
            }while (sum > 0);
        }
        return result;
    }
}
