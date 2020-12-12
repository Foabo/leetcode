import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        
        HashMap<Integer,Integer> mp  = new HashMap<>();
        HashSet<Integer> isInArr2  = new HashSet();
     
        int[] arr = new int[arr1.length];
        for (int num : arr1) {
            int a = mp.getOrDefault(num, 0);
            mp.put(num, a + 1);
        }

        int count=0;
        for (int num : arr2) {
            isInArr2.add(num);
            // mp.get(num)= arr1中的元素出现的个数
            for (int i = 0; i < mp.get(num); i++) {
                arr[count++] = num;
            }
        }
   
        int addLen = arr1.length - count;
    
        if (addLen == 0) {
            return arr;
        }
        int []sortedArr  = new int [addLen];
        int count2 = 0;
        for (int num : arr1) {
            if (!isInArr2.contains(num)) {
                sortedArr[count2++] = num;
            }
        }
        Arrays.sort(sortedArr);

        for (int i = 0; i < addLen; i++) {
            arr[count++] = sortedArr[i];
        }
 

        return arr;


    }
}
// @lc code=end

