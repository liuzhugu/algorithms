package practice.leetcode;

import java.util.*;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int candy :  candies) {
            map.put(candy,map.getOrDefault(candy,0) + 1);
        }
        if (map.values().size() * 2 >= candies.length) {
            return candies.length / 2;
        } else {
            return map.values().size();
        }
    }

    public int[] distributeCandies(int candies, int num_people) {
        //争取一次遍历解决问题
        int[] result = new int[num_people];
        for (int i = 0;i < num_people;i ++) {
            int j = i + 1,sum = (j - 1) * j / 2;
            while (sum < candies) {
                if (j + sum >= candies) {
                    result[i] = result[i] + candies - sum;
                } else {
                    result[i] =  result[i] + j;
                }
                j = j + num_people;
                sum = (j - 1) * j /2;
            }
        }
        return result;
    }
}
