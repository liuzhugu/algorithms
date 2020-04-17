package practice.jianzhi;

/**
 * Created by liuzhugu on 2020/04/17.
 * 面试题61. 扑克牌中的顺子
 *  从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 *  而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        int[] cards = new int[14];
        int min = Integer.MAX_VALUE,max = 0;
        int king = 0;
        for (int num : nums) {
            if (num == 0) {
                king ++;
            } else {
                cards[num] ++;
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
        }
        //从前往后
        if (min < 10) {
            for (int i = min + 1;i < min + 5;i ++) {
                if (cards[i] == 0) {
                    if (king == 0) {
                        return false;
                    } else {
                        king --;
                    }
                }
            }
            return true;
        }
        //从后往前
        else {
            for (int i = max - 1;i > max - 5;i --) {
                if (cards[i] == 0) {
                    if (king == 0) {
                        return false;
                    } else {
                        king --;
                    }
                }
            }
            return true;
        }
    }
}
