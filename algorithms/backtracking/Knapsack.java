package algorithms.backtracking;

/**
 * 0-1 背包问题
 * 每个货物要么状态是放入背包或者是不放入,只有两种
 *
 * */
public class Knapsack {

    /**
     * @param items 货物重量
     * @param backpackCapacity 背包容量
     * */
    public static int findMaxWeight(int[] items,int backpackCapacity) {
        int maxWeight = Integer.MIN_VALUE;
        return findMaxWeight(items, backpackCapacity, 0, 0, maxWeight);

    }

    /**
     * @param items 货物重量
     * @param capacity 背包容量
     * @param c 当前货物
     * @param cw 当前放入背包的货物的总重量
     * */
    private static int findMaxWeight(int[] items,int capacity,int c,int cw,int maxWeight){
        //所有货物都选择完或是当前放入背包的货物的总重量刚好等于背包容量为递归终止条件
        //前者是因为没得选了只能终止,而后者是已找到结果所以结束的
        if(c==(items.length-1)||cw==capacity){
            if(cw>maxWeight){
                maxWeight=cw;
            }
            return maxWeight;
        }
        //当前货物不放入背包
        int zeroWeight=maxWeight,oneWeight=maxWeight;
        zeroWeight=findMaxWeight(items,capacity,c+1,cw,maxWeight);
        if(cw+items[c]<=capacity){
            //当前货物放入背包
            oneWeight=findMaxWeight(items,capacity,c+1,cw+items[c],maxWeight);
        }
        return zeroWeight>oneWeight?zeroWeight:oneWeight;
    }
}
