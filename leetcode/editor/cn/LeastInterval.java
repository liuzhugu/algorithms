package leetcode.editor.cn;

/**
 * Created by liuzhugu on 2019/03/08.
 * 621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26
 * 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 * CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内
 * CPU 在执行不同的任务，或者在待命状态。你需要计算完成所有任务所需要的最短时间。
 */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        //任务统计
        int[] taskCount = new int[26];
        //所需时间
        int result = 0;
        //初始化
        for (int i = 0;i < 26;i ++) {
            taskCount[i] = 0;
        }
        for (int i = 0;i < tasks.length;i ++) {
            taskCount[tasks[i]-'A'] ++;
        }
        //优先放入次数最多的,否则留到后面的话,为了避开同类任务,要插入的间隔越大
        boolean[] shouldSkip = new boolean[26];
        for (int i = 0;i < 26;i ++) {
            shouldSkip[i] = false;
        }
        //离可以放进队列还差多少次
        int[] waitToPick = new int[26];
        for (int i = 0;i < 26;i ++) {
            //没被设置的就始终不会放入
            if (taskCount[i] > 0) {
                waitToPick[i] = 0;
            }else {
                //没有的任务始终不会被选上
                waitToPick[i] = Integer.MAX_VALUE;
            }
        }
        while (true) {
            boolean endFlag = true;
            for (int i = 0;i < 26;i ++) {
                if (taskCount[i] > 0) {
                    //还有任务没安排
                    endFlag = false;
                }
            }
            if (endFlag) {
                return result;
            }
            //找到能被放入且次数最大的
            while (true) {
                int select = -1,max = 0;
                for (int i = 0;i < 26;i ++) {
                    if (taskCount[i] > max && shouldSkip[i] == false) {
                        select = i;
                        max = taskCount[i];
                    }
                }
                //如果全部都不能选的话,该次待命
                if (select == -1) {
                    result ++;
                    break;
                }
                //判断选中的任务是否能放入
                if (waitToPick[select] <= 0) {
                    result ++;
                    taskCount[select] --;
                    //n次之后才能继续放入该任务
                    waitToPick[select] = n + 1;
                    break;
                }else {
                    //否则跳过该任务,即使它次数最多
                    shouldSkip[select] = true;
                }
            }
            //所有任务需等待被安排的时间缩小1
            for (int i = 0;i < 26;i ++) {
                waitToPick[i] --;
            }
            //从新初始化能被选中的
            for (int i = 0;i < 26;i ++) {
                shouldSkip[i] = false;
            }
        }
    }
}

