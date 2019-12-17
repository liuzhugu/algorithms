package practice.leetcode;

public class AddNegabinary {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1,j = arr2.length - 1;
        int size = i > j ? i + 1 : j + 1,index = size - 1;
        int[] result = new int[size];
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = arr1[i] + arr2[j] +  carry;
            if (sum == -1) {
                //需要向前借位
                result[index] = 1;
                carry = 1;
            }else if (sum >= 2) {
                result[index] = sum - 2;
                carry = -1;
            }else {
                result[index] = sum;
                carry = 0;
            }
            i --;
            j --;
            index --;
        }
        if (i < 0 && j >= 0) {
            while (j >= 0) {
                int sum = arr2[j] +  carry;
                if (sum == -1) {
                    //需要向前借位
                    result[index] = 1;
                    carry = 1;
                }else if (sum >= 2) {
                    result[index] = sum - 2;
                    carry = -1;
                }else {
                    result[index] = sum;
                    carry = 0;
                }
                j --;
                index --;
            }
        }
        if (i >=0 && j < 0) {
            while (i >= 0) {
                int sum = arr1[i] +  carry;
                if (sum == -1) {
                    //需要向前借位
                    result[index] = 1;
                    carry = 1;
                }else if (sum >= 2) {
                    result[index] = sum - 2;
                    carry = -1;
                }else {
                    result[index] = sum;
                    carry = 0;
                }
                i --;
                index --;
            }
        }
        if (carry == -1) {
            int[] tmp = new int[size + 2];
            tmp[0] = 1;
            tmp[1] = 1;
            for (index = 0;index < size;index ++) {
                tmp[index + 2] = result[index];
            }
            return tmp;
        }else {
            for (index = 0;index < size;index ++) {
                if (result[index] == 1) {
                    break;
                }
            }
            if (index == size) {
                return new int[]{0};
            }else if (index == 0){
                return result;
            }else {
                int[] tmp = new int[size - index];
                for (int k = 0;k < size - index;k ++) {
                    tmp[k] = result[k + index];
                }
                return tmp;
            }
        }
    }}
