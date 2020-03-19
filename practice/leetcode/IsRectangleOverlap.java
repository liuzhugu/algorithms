package practice.leetcode;

/**
 * Created by liuzhugu on 2020/03/18.
 * 836. 矩形重叠
 *  矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 给出两个矩形，判断它们是否重叠并返回结果。
 */
public class IsRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = 0,y1 = 1,x2 = 2,y2 = 3;
        if (rec1[x1] > rec2[x1]) {
          int[] tmp = rec1;
          rec1 = rec2;
          rec2 = tmp;
        }
        if (rec1[x2] <= rec2[x1]) {
            return false;
        }
        if (rec1[y1] > rec2[y1]) {
            int[] tmp = rec1;
            rec1 = rec2;
            rec2 = tmp;
        }
        //大于左边  相交一部分  大于右边   那就是包含
        if (rec1[y2] <= rec2[y1]) {
            return false;
        }
        return true;
    }
}
