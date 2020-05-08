//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
//
// 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 1 <= numCourses <= 10^5 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：207:课程表 并查集 2020/05/07
public class CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        //TO TEST
        solution.canFinish(5,new int[][]{{1,0},{2,1},{0,1}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //BFS
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null || prerequisites.length == 0) {
                return true;
            }
            int m = prerequisites.length;
            //用链表建立图
            List<Integer>[] graph = new ArrayList[numCourses];
            visited = new boolean[numCourses];
            for (int i = 0;i < numCourses;i ++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0;i < m;i ++) {
                int[] requisite = prerequisites[i];
                int from = requisite[1],to = requisite[0];
                graph[from].add(to);
            }
            //因为是森林  所以每个节点都要试一试
            for (int i = 0;i < numCourses;i ++) {
                //如果已访问过  那么不用访问了
                if (! visited[i]) {
                    if (! visit(graph,i,new HashSet<>())) {
                        return false;
                    }
                }
            }
            return true;
        }
        private boolean[] visited;
        private boolean visit(List<Integer>[] graph, int from, Set<Integer> visitSet) {
            visited[from] = true;
            List<Integer> list = graph[from];
            //到了尽头
            if (list.isEmpty()) {
                return true;
            }
            for (int i = 0;i < list.size();i ++) {
                //出现回环
                if (visitSet.contains(list.get(i))) {
                    return false;
                }
                visitSet.add(list.get(i));
                if (! visit(graph,list.get(i),visitSet)) {
                    return false;
                }
                visitSet.remove(list.get(i));
            }
            return true;
        }

        //并查集不行  因为不是父节点可能不止一个
//        //找根节点
//        private int find(int x) {
//            //如果再次遇到同一节点 说明出现回环
//            Set<Integer> set = new HashSet<>();
//            while (courses[x] != x) {
//                x = courses[x];
//                if (set.contains(x)) {
//                    return -1;
//                } else {
//                    set.add(x);
//                }
//            }
//            return x;
//        }
//        private boolean isParent (int x,int y) {
//            while (courses[x] != x) {
//                if (courses[x] == y) {
//                    return true;
//                }
//                x = courses[x];
//            }
//            return false;
//        }
//        //建立连接
//        private boolean build(int x,int y) {
//            int xRoot = find(x),yRoot = find(y);
//            if (xRoot == -1 || yRoot == -1) {
//                return false;
//            }
//            //已在同一个树上
//            if (xRoot == yRoot) {
//                //判断是否有回环
//                if (isParent(x,y)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//            //连通两者
//            courses[x] = y;
//            return true;
//        }
//        private int[] courses;
//        //找最大深度  如果最大深度跟课程数一样就可以
//        private int max = Integer.MIN_VALUE;
//        //出现回环或者深度不够都不满足条件
//        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            if (prerequisites == null || prerequisites.length == 0) {
//                return true;
//            }
//            int m = prerequisites.length;
//            courses = new int[numCourses];
//            //初始化 每个节点的根节点初始化为它自己
//            for (int i = 0;i < numCourses;i ++) {
//                courses[i] = i;
//            }
//            for (int i = 0;i < m;i ++) {
//                int[] prerequisite = prerequisites[i];
//                if (! build(prerequisite[0],prerequisite[1])) {
//                    return false;
//                }
//            }
//            //找回环
//            for (int i = 0;i < numCourses;i ++) {
//                find(i);
//            }
//            return true;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}