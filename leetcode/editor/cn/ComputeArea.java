package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2019/07/20.
 * 223. 矩形面积
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 **/

public class ComputeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //求得两个矩形面积之和   减去公共部分
        int areaFirst = 0, areaSecond = 0,areaCommon = 0;
        areaFirst = Math.abs(C - A) * Math.abs(D - B);
        areaSecond = Math.abs(G - E) * Math.abs(H - F);
        //有重合部分
        if(!(E >= C || G <= A || F >= D || H <= B)) {
            int commonWidth = Math.min(G,C) - Math.max(A,E);
            int commonHeight = Math.min(H,D) - Math.max(F,B);
            areaCommon = commonHeight * commonWidth;
        }
        return areaFirst + areaSecond - areaCommon;
    }
}
