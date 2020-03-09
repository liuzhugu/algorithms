package practice.jianzhi;

public class Test {
    public static void main(String[] args) {
//        ReverseWords reverseWords = new ReverseWords();
//        System.out.println(reverseWords.reverseWords("the sky is blue!"));

//        CQueue cQueue = new CQueue();
//        cQueue.appendTail(3);
//        cQueue.appendTail(4);
//        System.out.println(cQueue.deleteHead());
//        cQueue.appendTail(5);
//        cQueue.appendTail(6);
//        System.out.println(cQueue.deleteHead());
//        System.out.println(cQueue.deleteHead());

        //FirstUniqChar firstUniqChar = new FirstUniqChar();
        //System.out.println(firstUniqChar.firstUniqChar("leecode"));

        //SingleNumbers singleNumbers = new SingleNumbers();
        //System.out.println(singleNumbers.singleNumbers(new int[]{4,1,4,6}));

        //HammingWeight hammingWeight = new HammingWeight();
        //System.out.println(hammingWeight.hammingWeight(1));

        //MinArray minArray = new MinArray();
        //System.out.println(minArray.minArray(new int[]{1,3,3}));

        Codec codec = new Codec();
        TreeNode treeNode = codec.deserialize("[]");
        System.out.println(codec.serialize(treeNode));
    }
}
