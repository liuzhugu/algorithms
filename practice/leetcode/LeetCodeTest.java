package practice.leetcode;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.*;

public class LeetCodeTest {

    public static void main(String[] args) {
//        //677 键值映射
//        MapSum mapSum = new MapSum();
//        mapSum.insert("apple", 3);
//        System.out.println(mapSum.sum("ap"));
//        mapSum.insert("app", 2);
//        System.out.println(mapSum.sum("ap"));

        //297 二叉树的序列化与反序列化
//        TreeNode root = new TreeNode(1);
//        TreeNode first = new TreeNode(2);
//        root.left = first;
//        TreeNode second = new TreeNode(3);
//        root.right = second;
//        TreeNode third = new TreeNode(4);
//        first.left = third;
//        TreeNode fouth = new TreeNode(5);
//        second.right = fouth;
//        Codec codec = new Codec();
//        System.out.println(codec.serialize(root));
//        System.out.println(codec.deserialize(codec.serialize(root)));
//        String str = "[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9,null,10,null,11,null,12,null,13,null,14,null,15,null,16,null,17,null,18,null,19,null,20,null,21,null,22,null,23,null,24,null,25,null,26,null,27,null,28,null,29,null,30,null,31,null,32,null,33,null,34,null,35,null,36,null,37,null,38,null,39,null,40,null,41,null,42,null,43,null,44,null,45,null,46,null,47,null,48,null,49,null,50,null,51,null,52,null,53,null,54,null,55,null,56,null,57,null,58,null,59,null,60,null,61,null,62,null,63,null,64,null,65,null,66,null,67,null,68,null,69,null,70,null,71,null,72,null,73,null,74,null,75,null,76,null,77,null,78,null,79,null,80,null,81,null,82,null,83,null,84,null,85,null,86,null,87,null,88,null,89,null,90,null,91,null,92,null,93,null,94,null,95,null,96,null,97,null,98,null,99,null,100,null,101,null,102,null,103,null,104,null,105,null,106,null,107,null,108,null,109,null,110,null,111,null,112,null,113,null,114,null,115,null,116,null,117,null,118,null,119,null,120,null,121,null,122,null,123,null,124,null,125,null,126,null,127,null,128,null,129,null,130,null,131,null,132,null,133,null,134,null,135,null,136,null,137,null,138,null,139,null,140,null,141,null,142,null,143,null,144,null,145,null,146,null,147,null,148,null,149,null,150,null,151,null,152,null,153,null,154,null,155,null,156,null,157,null,158,null,159,null,160,null,161,null,162,null,163,null,164,null,165,null,166,null,167,null,168,null,169,null,170,null,171,null,172,null,173,null,174,null,175,null,176,null,177,null,178,null,179,null,180,null,181,null,182,null,183,null,184,null,185,null,186,null,187,null,188,null,189,null,190,null,191,null,192,null,193,null,194,null,195,null,196,null,197,null,198,null,199,null,200,null,201,null,202,null,203,null,204,null,205,null,206,null,207,null,208,null,209,null,210,null,211,null,212,null,213,null,214,null,215,null,216,null,217,null,218,null,219,null,220,null,221,null,222,null,223,null,224,null,225,null,226,null,227,null,228,null,229,null,230,null,231,null,232,null,233,null,234,null,235,null,236,null,237,null,238,null,239,null,240,null,241,null,242,null,243,null,244,null,245,null,246,null,247,null,248,null,249,null,250,null,251,null,252,null,253,null,254,null,255,null,256,null,257,null,258,null,259,null,260,null,261,null,262,null,263,null,264,null,265,null,266,null,267,null,268,null,269,null,270,null,271,null,272,null,273,null,274,null,275,null,276,null,277,null,278,null,279,null,280,null,281,null,282,null,283,null,284,null,285,null,286,null,287,null,288,null,289,null,290,null,291,null,292,null,293,null,294,null,295,null,296,null,297,null,298,null,299,null,300,null,301,null,302,null,303,null,304,null,305,null,306,null,307,null,308,null,309,null,310,null,311,null,312,null,313,null,314,null,315,null,316,null,317,null,318,null,319,null,320,null,321,null,322,null,323,null,324,null,325,null,326,null,327,null,328,null,329,null,330,null,331,null,332,null,333,null,334,null,335,null,336,null,337,null,338,null,339,null,340,null,341,null,342,null,343,null,344,null,345,null,346,null,347,null,348,null,349,null,350,null,351,null,352,null,353,null,354,null,355,null,356,null,357,null,358,null,359,null,360,null,361,null,362,null,363,null,364,null,365,null,366,null,367,null,368,null,369,null,370,null,371,null,372,null,373,null,374,null,375,null,376,null,377,null,378,null,379,null,380,null,381,null,382,null,383,null,384,null,385,null,386,null,387,null,388,null,389,null,390,null,391,null,392,null,393,null,394,null,395,null,396,null,397,null,398,null,399,null,400,null,401,null,402,null,403,null,404,null,405,null,406,null,407,null,408,null,409,null,410,null,411,null,412,null,413,null,414,null,415,null,416,null,417,null,418,null,419,null,420,null,421,null,422,null,423,null,424,null,425,null,426,null,427,null,428,null,429,null,430,null,431,null,432,null,433,null,434,null,435,null,436,null,437,null,438,null,439,null,440,null,441,null,442,null,443,null,444,null,445,null,446,null,447,null,448,null,449,null,450,null,451,null,452,null,453,null,454,null,455,null,456,null,457,null,458,null,459,null,460,null,461,null,462,null,463,null,464,null,465,null,466,null,467,null,468,null,469,null,470,null,471,null,472,null,473,null,474,null,475,null,476,null,477,null,478,null,479,null,480,null,481,null,482,null,483,null,484,null,485,null,486,null,487,null,488,null,489,null,490,null,491,null,492,null,493,null,494,null,495,null,496,null,497,null,498,null,499,null,500,null,501,null,502,null,503,null,504,null,505,null,506,null,507,null,508,null,509,null,510,null,511,null,512,null,513,null,514,null,515,null,516,null,517,null,518,null,519,null,520,null,521,null,522,null,523,null,524,null,525,null,526,null,527,null,528,null,529,null,530,null,531,null,532,null,533,null,534,null,535,null,536,null,537,null,538,null,539,null,540,null,541,null,542,null,543,null,544,null,545,null,546,null,547,null,548,null,549,null,550,null,551,null,552,null,553,null,554,null,555,null,556,null,557,null,558,null,559,null,560,null,561,null,562,null,563,null,564,null,565,null,566,null,567,null,568,null,569,null,570,null,571,null,572,null,573,null,574,null,575,null,576,null,577,null,578,null,579,null,580,null,581,null,582,null,583,null,584,null,585,null,586,null,587,null,588,null,589,null,590,null,591,null,592,null,593,null,594,null,595,null,596,null,597,null,598,null,599,null,600,null,601,null,602,null,603,null,604,null,605,null,606,null,607,null,608,null,609,null,610,null,611,null,612,null,613,null,614,null,615,null,616,null,617,null,618,null,619,null,620,null,621,null,622,null,623,null,624,null,625,null,626,null,627,null,628,null,629,null,630,null,631,null,632,null,633,null,634,null,635,null,636,null,637,null,638,null,639,null,640,null,641,null,642,null,643,null,644,null,645,null,646,null,647,null,648,null,649,null,650,null,651,null,652,null,653,null,654,null,655,null,656,null,657,null,658,null,659,null,660,null,661,null,662,null,663,null,664,null,665,null,666,null,667,null,668,null,669,null,670,null,671,null,672,null,673,null,674,null,675,null,676,null,677,null,678,null,679,null,680,null,681,null,682,null,683,null,684,null,685,null,686,null,687,null,688,null,689,null,690,null,691,null,692,null,693,null,694,null,695,null,696,null,697,null,698,null,699,null,700,null,701,null,702,null,703,null,704,null,705,null,706,null,707,null,708,null,709,null,710,null,711,null,712,null,713,null,714,null,715,null,716,null,717,null,718,null,719,null,720,null,721,null,722,null,723,null,724,null,725,null,726,null,727,null,728,null,729,null,730,null,731,null,732,null,733,null,734,null,735,null,736,null,737,null,738,null,739,null,740,null,741,null,742,null,743,null,744,null,745,null,746,null,747,null,748,null,749,null,750,null,751,null,752,null,753,null,754,null,755,null,756,null,757,null,758,null,759,null,760,null,761,null,762,null,763,null,764,null,765,null,766,null,767,null,768,null,769,null,770,null,771,null,772,null,773,null,774,null,775,null,776,null,777,null,778,null,779,null,780,null,781,null,782,null,783,null,784,null,785,null,786,null,787,null,788,null,789,null,790,null,791,null,792,null,793,null,794,null,795,null,796,null,797,null,798,null,799,null,800,null,801,null,802,null,803,null,804,null,805,null,806,null,807,null,808,null,809,null,810,null,811,null,812,null,813,null,814,null,815,null,816,null,817,null,818,null,819,null,820,null,821,null,822,null,823,null,824,null,825,null,826,null,827,null,828,null,829,null,830,null,831,null,832,null,833,null,834,null,835,null,836,null,837,null,838,null,839,null,840,null,841,null,842,null,843,null,844,null,845,null,846,null,847,null,848,null,849,null,850,null,851,null,852,null,853,null,854,null,855,null,856,null,857,null,858,null,859,null,860,null,861,null,862,null,863,null,864,null,865,null,866,null,867,null,868,null,869,null,870,null,871,null,872,null,873,null,874,null,875,null,876,null,877,null,878,null,879,null,880,null,881,null,882,null,883,null,884,null,885,null,886,null,887,null,888,null,889,null,890,null,891,null,892,null,893,null,894,null,895,null,896,null,897,null,898,null,899,null,900,null,901,null,902,null,903,null,904,null,905,null,906,null,907,null,908,null,909,null,910,null,911,null,912,null,913,null,914,null,915,null,916,null,917,null,918,null,919,null,920,null,921,null,922,null,923,null,924,null,925,null,926,null,927,null,928,null,929,null,930,null,931,null,932,null,933,null,934,null,935,null,936,null,937,null,938,null,939,null,940,null,941,null,942,null,943,null,944,null,945,null,946,null,947,null,948,null,949,null,950,null,951,null,952,null,953,null,954,null,955,null,956,null,957,null,958,null,959,null,960,null,961,null,962,null,963,null,964,null,965,null,966,null,967,null,968,null,969,null,970,null,971,null,972,null,973,null,974,null,975,null,976,null,977,null,978,null,979,null,980,null,981,null,982,null,983,null,984,null,985,null,986,null,987,null,988,null,989,null,990,null,991,null,992,null,993,null,994,null,995,null,996,null,997,null,998,null,999,null,1000]";
//        String str = "[1]";
//        Codec codec = new Codec();
//        TreeNode treeNode=codec.deserialize(str);
//        codec.serialize(treeNode);

//        ListNode first = new ListNode(1);
//        ListNode second = new ListNode(2);
//        first.next = second;
//        ListNode third = new ListNode(3);
//        second.next = third;
//        ListNode fouth = new ListNode(4);
//        third.next = fouth;
//
//        ListNode first1 = new ListNode(1);
//        ListNode second1 = new ListNode(2);
//        first1.next = second1;
//        ListNode third1 = new ListNode(3);
//        second1.next = third1;
//        ListNode fouth1 = new ListNode(8);
//        third1.next = fouth1;
//
//        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        ListNode result = addTwoNumbers.addTwoNumbers(first,first1);
//        System.out.print(result.val);

        //890 查找和替换模式
//        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
//        String pattern = "abb";
//        FindAndReplacePattern findAndReplacePattern = new FindAndReplacePattern();
//        findAndReplacePattern.findAndReplacePattern(words,pattern);

        //306. 累加数
//        IsAdditiveNumber isAdditiveNumber = new IsAdditiveNumber();
//        System.out.println(isAdditiveNumber.isAdditiveNumber("01123"));
//        System.out.println(isAdditiveNumber.isAdditiveNumber("111122335588143"));
//        System.out.println(isAdditiveNumber.isAdditiveNumber("101020305080130210"));

        //621. 任务调度器
//        LeastInterval leastInterval = new LeastInterval();
//        char[] chars = new char[]{'A','A','A', 'B','B','B'};
//        System.out.println(leastInterval.leastInterval(chars,2));

        //328. 奇偶链表
//        ListNode head = new ListNode(1);
//        ListNode first = new ListNode(2);
//        head.next = first;
//        ListNode second = new ListNode(3);
//        first.next = second;
//        ListNode third = new ListNode(4);
//        second.next = third;
//        ListNode fouth = new ListNode(5);
//        third.next = fouth;
//        OddEvenList oddEvenList = new OddEvenList();
//        head = oddEvenList.oddEvenList(head);
//        System.out.print(head);

        //701. 二叉搜索树中的插入操作
        //InsertIntoBST insertIntoBST = new InsertIntoBST();

        //907. 子数组的最小值之和
        //SumSubarrayMins sumSubarrayMins = new SumSubarrayMins();
        //System.out.println(sumSubarrayMins.sumSubarrayMins(new int[]{4,21,26,35,50,61,68,82,88,92,97,90,85,79,68,50,50,33,22,15}));

        //334. 递增的三元子序列
//        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
//        System.out.println(increasingTriplet.increasingTriplet(new int[]{1,1,1,1}));
//        System.out.println(increasingTriplet.increasingTriplet(new int[]{2,1,5,0,3}));
//        System.out.println(increasingTriplet.increasingTriplet(new int[]{1,2,3,4,5}));
//        System.out.println(increasingTriplet.increasingTriplet(new int[]{5,4,3,2,1}));

        //392. 判断子序列
//        IsSubsequence subsequence = new IsSubsequence();
//        System.out.println(subsequence.isSubsequence("axc","ahbgdc"));

        //646. 最长数对链
//        FindLongestChain findLongestChain = new FindLongestChain();
//        int[][] pairs = new int[][]{{1,9},{-6,10},{-5,8},{5,8},{2,7},{-8,-3},{2,6},{-4,-2},{4,5},{0,4}} ;
//        System.out.println(findLongestChain.findLongestChain(pairs));

        //135. 分发糖果
//        Candy candy = new Candy();
//        System.out.print(candy.candy(new int[]{1,6,10,8,7,3,2}));

        //63. 不同路径 II
        //UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        //System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},{1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},{1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},{1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}}));

        //51. N皇后
        //SolveNQueens solveNQueens = new SolveNQueens();
        //System.out.println(solveNQueens.solveNQueens(4));

        //792. 匹配子序列的单词数
        //NumMatchingSubseq numMatchingSubseq = new NumMatchingSubseq();
        //System.out.println(numMatchingSubseq.numMatchingSubseq("abcde",new String[]{"a","bb","acd","ace"}));

        //216. 组合总和 III
        //CombinationSum3 combinationSum3 = new CombinationSum3();
        //System.out.println(combinationSum3.combinationSum3(3,7).size());

        //954. 二倍数对数组
        //CanReorderDoubled canReorderDoubled = new CanReorderDoubled();
        //System.out.println(canReorderDoubled.canReorderDoubled(new int[]{4,-2,2,-4}));

        //114. 二叉树展开为链表
//        TreeNode first = new TreeNode(1);
//        TreeNode second  = new TreeNode(2);
//        TreeNode fith = new TreeNode(5);
//        first.left = second;
//        first.right = fith;
//        TreeNode third = new TreeNode(3);
//        TreeNode fourth = new TreeNode(4);
//        second.left = third;
//        second.right = fourth;
//        Flatten flatten =new Flatten();
//        flatten.flatten(first);

        //767. 重构字符串
        // ReorganizeString reorganizeString = new ReorganizeString();
        //System.out.println(reorganizeString.reorganizeString("aab"));

        //973. 最接近原点的 K 个点
        //KClosest kClosest = new KClosest();
        //System.out.println(kClosest.kClosest(new int[][]{{3,3},{5,-1},{-2,4}},2));

        //695. 岛屿的最大面积
        //MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        //System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{{1,1,1},{1,0,1}}));

        //542. 01 矩阵
        //UpdateMatrix updateMatrix = new UpdateMatrix();
        //System.out.println(updateMatrix.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}}));

        //462. 最少移动次数使数组元素相等 II
        //MinMoves2 minMoves2 = new MinMoves2();
        //System.out.println(minMoves2.minMoves2(new int[]{1,2,3,11,55,145,246,256}));

        //1007. 行相等的最少多米诺旋转
        //MinDominoRotations minDominoRotations = new MinDominoRotations();
        //System.out.println(minDominoRotations.minDominoRotations(new int[]{3,5,1,2,3},new int[]{5,3,3,3,4}));

        //33. 搜索旋转排序数组
        //Search search = new Search();
        //System.out.println(search.search(new int[]{5,1,2,3,4},1));

        //971. 翻转二叉树以匹配先序遍历
        //FlipMatchVoyage flipMatchVoyage = new FlipMatchVoyage();
        //TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(2);
//        root.left =  left;
//        TreeNode right = new TreeNode(3);
//        root.right = right;
        //System.out.println(flipMatchVoyage.flipMatchVoyage(root,new int[]{1}));

        //223. 矩形面积
        //ComputeArea computeArea = new ComputeArea();
        //System.out.println(computeArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));

        //781. 森林中的兔子
        //NumRabbits numRabbits = new NumRabbits();
        //System.out.println(numRabbits.numRabbits(new int[]{0,0,1,1,1,1,1}));

        //767. 重构字符串
        //ReorganizeString reorganizeString = new ReorganizeString();
        //System.out.println(reorganizeString.reorganizeString("bfrbs"));

        //567. 字符串的排列
        //CheckInclusion checkInclusion = new CheckInclusion();
        //System.out.println(checkInclusion.checkInclusion("adc","dcda"));

        //System.out.println("[[0,0,0],[0,1,0],[0,0,0]]".replace("[","{").replace("]","}"));

        //1218. 最长定差子序列
        //LongestSubsequence longestSubsequence = new LongestSubsequence();
        //System.out.println(longestSubsequence.longestSubsequence(new int[]{3,4,-3,-2,-4},-5));

        //658. 找到K个最接近的元素
        //FindClosestElements findClosestElements = new FindClosestElements();
        //System.out.println(findClosestElements.findClosestElements(new int[]{1,2,3,4,5},4,3));

        //1019. 链表中的下一个更大节点
//        NextLargerNodes nextLargerNodes = new NextLargerNodes();
//        //[7,2,6,6,9,4,3]
//        ListNode head = new ListNode(7);
//        ListNode node1 = new ListNode(2);
//        head.next = node1;
//        ListNode node2 = new ListNode(6);
//        node1.next = node2;
//        ListNode node3 = new ListNode(6);
//        node2.next = node3;
//        ListNode node4 = new ListNode(9);
//        node3.next = node4;
//        ListNode node5 = new ListNode(4);
//        node4.next = node5;
//        ListNode node6 = new ListNode(3);
//        node5.next = node6;
//        System.out.println(nextLargerNodes.nextLargerNodes(head));

        //886. 可能的二分法
        //PossibleBipartition possibleBipartition = new PossibleBipartition();
        //System.out.println(possibleBipartition.possibleBipartition(4,new int[][]{{1,2},{1,3},{2,4}}));

        //813. 最大平均值和的分组
        //LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
        //System.out.println(largestSumOfAverages.largestSumOfAverages(new int[]{9,1,2,3,9},3));

        //113. 路径总和 II
//        String line = "[1,-2,-3,1,3,-2,null,-1]";
//        PathSum pathSum = new PathSum();
//        TreeNode root = stringToTreeNode(line);
//        System.out.println(pathSum.pathSum(root,2));

        //554. 砖墙
//        LeastBricks leastBricks = new LeastBricks();
//        List<List<Integer>> lists = new ArrayList<>();
//        lists.add(Arrays.asList(new Integer[]{100000000}));
//        lists.add(Arrays.asList(new Integer[]{100000000}));
//        lists.add(Arrays.asList(new Integer[]{100000000}));
//        lists.add(Arrays.asList(new Integer[]{2,4}));
//        lists.add(Arrays.asList(new Integer[]{3,1,2}));
//        lists.add(Arrays.asList(new Integer[]{1,3,1,1}));
//        System.out.println(leastBricks.leastBricks(lists));

        //1073. 负二进制数相加
        //AddNegabinary addNegabinary = new AddNegabinary();
        //System.out.println(addNegabinary.addNegabinary(new int[]{1,1,0,1},new int[]{1}));

        //785. 判断二分图
        //IsBipartite isBipartite = new IsBipartite();
        //System.out.println(isBipartite.isBipartite(new int[][]{{1,3}, {0,2}, {1,3}, {0,2}}));

        //1023. 驼峰式匹配
        //CamelMatch camelMatch = new CamelMatch();
        //System.out.println(camelMatch.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FB"));

        //518. 零钱兑换 II
        //Change change = new Change();
        //System.out.println(change.change(3,new int[]{2}));

        //1288. 删除被覆盖区间
//        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();

        //1043. 分隔数组以得到最大和
//        MaxSumAfterPartitioning maxSumAfterPartitioning = new MaxSumAfterPartitioning();
//        System.out.println(maxSumAfterPartitioning.maxSumAfterPartitioning(new int[]{
//                1,15,7,9,2,5,10
//        },3));

        //1011. 在 D 天内送达包裹的能力
        //ShipWithinDays shipWithinDays = new ShipWithinDays();
        //System.out.println(shipWithinDays.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));

        //524. 通过删除字母匹配到字典里最长单词
        //FindLongestWord findLongestWord = new FindLongestWord();
        //String[] strings = new String[]{"ale","apple","monkey","plea"};
        //System.out.println(findLongestWord.findLongestWord("abpcplea",Arrays.asList(strings)));

        //82. 删除排序链表中的重复元素 II
        //DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        //System.out.println(deleteDuplicates.deleteDuplicates(stringToListNode("[1,1,1,1,1]")));

        //450. 删除二叉搜索树中的节点
        //DeleteTreeNode deleteTreeNode = new DeleteTreeNode();
        //System.out.println(deleteTreeNode.deleteNode(stringToTreeNode("[5,3,6,2,4,null,7]"),3));

        //143. 重排链表
        //ReorderList reorderList = new ReorderList();
        //reorderList.reorderList(stringToListNode("[1]"));

        //919. 完全二叉树插入器
//        CBTInserter cbtInserter = new CBTInserter(stringToTreeNode("[1,2,3,4,5,6]"));
//        System.out.println(cbtInserter.insert(7));
//        System.out.println(cbtInserter.insert(8));
//        System.out.println(cbtInserter.insert(9));
//        cbtInserter.get_root();

        //743. 网络延迟时间
        //NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        //System.out.println(networkDelayTime.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));

        //1302. 层数最深叶子节点的和
        //DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        //System.out.println(deepestLeavesSum.deepestLeavesSum(stringToTreeNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]")));

        //322. 零钱兑换
        //CoinChange coinChange = new CoinChange();
        //System.out.println(coinChange.coinChange(new int[]{1,2,5},11));

        //121. 买卖股票的最佳时机
        //MaxProfit maxProfit = new MaxProfit();
        //System.out.println(maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));

        //945. 使数组唯一的最小增量
        //MinIncrementForUnique minIncrementForUnique = new MinIncrementForUnique();
        //System.out.println(minIncrementForUnique.minIncrementForUnique(new int[]{1,1,1,5,6}));

        //System.out.println(str.replace(" ","").replace("[","{").replace("]","}").replace("\n",""));

        //876. 链表的中间结点
        //MiddleNode middleNode = new MiddleNode();
        //System.out.println(middleNode.middleNode(stringToListNode("[1,2,3,4,5,6]")));

        //892. 三维形体的表面积
        //SurfaceArea surfaceArea = new SurfaceArea();
        //System.out.println(surfaceArea.surfaceArea(new int[][]{{1,0},{0,2}}));

        //914. 卡牌分组
        //HasGroupsSizeX hasGroupsSizeX = new HasGroupsSizeX();
        //System.out.println(hasGroupsSizeX.hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));

        //820. 单词的压缩编码
        //MinimumLengthEncoding minimumLengthEncoding = new MinimumLengthEncoding();
        //System.out.println(minimumLengthEncoding.minimumLengthEncoding(new String[]{"time", "me", "bell","abell"}));

        //1162. 地图分析
        //MaxDistance maxDistance = new MaxDistance();
        //System.out.println(maxDistance.maxDistance(new int[][]{{0,0,1,1,1},{0,1,1,0,0},{0,0,1,1,0},{1,0,0,0,0},{1,1,0,0,1}}));

        //912. 排序数组
        //SortArray sortArray = new SortArray();
        //System.out.println(sortArray.sortArray(new int[]{5,2,3,1,4,0,6,7,8,-1}));

        //42. 接雨水
        //Trap trap = new Trap();
        //System.out.println(trap.trap(new int[]{5,4,3,0,0,4,5}));

        //460. LFU缓存
//        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // 返回 1
//        cache.put(3, 3);    // 去除 key 2
//        cache.get(2);       // 返回 -1 (未找到key 2)
//        cache.get(3);       // 返回 3
//        cache.put(4, 4);    // 去除 key 1
//        cache.get(1);       // 返回 -1 (未找到 key 1)
//        cache.get(3);       // 返回 3
//        cache.get(4);       // 返回 4

        //72. 编辑距离
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("horse","ros"));
    }


    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

}
