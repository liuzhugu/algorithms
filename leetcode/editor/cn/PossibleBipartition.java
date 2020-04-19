package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhugu on 2019/12/11.
 * 886. 可能的二分法
 * 给定一组N人（编号为 1,2, ...,N）， 我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 形式上，如果dislikes[i]=[a,b]，表示不允许将编号为a和b的人归入同一组。
 * 当可以用这种方法将每个人分进两组时，返回true；否则返回false。
 */
public class PossibleBipartition {
    //并查集
    //题目只给出不喜欢关系,因此只能扩展自己不喜欢序列,根据不喜欢构造成树
    int[] father;
    public boolean possibleBipartition(int N_, int[][] dislikes){
        int N = N_ + 1;
        father = new int[2 * N + 5];
        //初始化
        for (int i = 0;i < 2 * N + 5;i ++) {
            father[i] = i;
        }
        for (int i = 0;i < dislikes.length;i ++) {
            //找自己的根节点
            int x = find(dislikes[i][0]);
            int y = find(dislikes[i][1]);
            //找自己不喜欢的人的根节点
            int a = find(dislikes[i][0] + N);
            int b = find(dislikes[i][1] + N);
            //根节点相同说明两人在一棵树上
            if (x == y) {
                return false;
            }else {
                //两人不在同一棵树上,那么相互在对方不喜欢的人的树上
                father[a] = y;
                father[b] = x;
            }
        }
        return true;
    }
    //此处用树的好处是合并链表公共部分
    int find(int x) {
        //相等的话说明它就是根节点，否则往上追溯
        if (x != father[x])
            father[x] = find(father[x]);
        return father[x];
    }

    //递归回溯法  超时
    //问题的关键是首尾不能在同一组
    public boolean possibleBipartition1(int N, int[][] dislikes) {
        List<Integer> group1 = new ArrayList<>(),group2 = new ArrayList<>();
        return possibleBipartition(dislikes,0,group1,group2);
    }
    boolean possibleBipartition(int[][] dislikes, int index, List<Integer> group1, List<Integer> group2) {
        if (index == dislikes.length) {
            return true;
        }
        int head = dislikes[index][0],tail = dislikes[index][1];
        //正放
        if (!group2.contains(head) && !group1.contains(tail)) {
            List<Integer> group1Copy = new ArrayList<>(group1);
            List<Integer> group2Copy = new ArrayList<>(group2);
            group1Copy.add(head);
            group2Copy.add(tail);
            boolean possible = possibleBipartition(dislikes,index + 1,group1Copy,group2Copy);
            if (possible) {
                return true;
            }
        }
        //反放
        if (!group1.contains(head) && !group2.contains(tail)) {
            group1.add(tail);
            group2.add(head);
            boolean possible = possibleBipartition(dislikes,index + 1,group1,group2);
            if (possible) {
                return true;
            }
        }
        return false;
    }
}
