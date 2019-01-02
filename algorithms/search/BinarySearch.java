package algorithms.search;

/**
 *  Created by liuzhugu on 2018/11/12
 *  二分查找法
 *  平均时间复杂度:O(logn)
 */
public class BinarySearch {

    //非递归
    public static int bsearch(int[] nums,int goal){
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==goal){
                return mid;
            }else if(nums[mid]>goal){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }

        return -1;
    }

    //查找第一个值等于给定值的元素
    public static int findFirst(int[] nums,int goal){
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+((end-start)>>1);
            if(nums[mid]>goal){
                end=mid-1;
            }else if(nums[mid]<goal){
                start=mid+1;
            }else{
                if(mid==0||nums[mid-1]!=goal){
                    return mid;
                }
                end=mid-1;
            }
        }

        return -1;
    }

    //查找最后一个值等于给定值的元素
    public static int findLast(int[] nums,int goal){
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+((end-start)>>1);
            if(nums[mid]>goal){
                end=mid-1;
            }else if(nums[mid]<goal){
                start=mid+1;
            }else{
                if(mid==nums.length-1||nums[mid+1]!=goal){
                    return mid;
                }
                start=mid+1;
            }
        }

        return -1;
    }

    //递归
    public static int bsearchInternally(int[] nums,int goal){
        return bsearchInternally(nums,goal,0,nums.length-1);
    }
    public static int bsearchInternally(int[] nums,int goal,int start,int end){
        if(start>end){
            return -1;
        }

        int mid=(start+end)/2;
        if(nums[mid]==goal){
            return mid;
        }else if(nums[mid]>goal){
            return bsearchInternally(nums,goal,start,mid-1);
        }else {
            return bsearchInternally(nums,goal,mid+1,end);
        }
    }

}
