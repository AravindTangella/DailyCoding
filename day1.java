
Problem 1 :   Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest 
	      positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

Solution:
	class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {         
            if(nums[i] > 0 && nums[i] < min)
                min = nums[i];   
            
            if(nums[i] > 0 && nums[i] > max)
                max = nums[i];
        }
        
        if(min > 1)
            return 1;
        
        for(int i = 0; i < n; i++) {
            int currentVal = nums[i];        
            while(currentVal > 0 && currentVal <= n && nums[i] != nums[currentVal-1]) {
                nums[i] = nums[currentVal-1];
                nums[currentVal-1] = currentVal;
                currentVal = nums[i];
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] != i+1)
                return i+1;
        }
        
        return max+1;
    }
}


Problem 2 :  Given an array of integers,return a new array such that each element at index i of the new array is the product of all the numbers in the 
             original array except the one at i. Note: without using division operator

Solution:
	class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        
        pre[0] = nums[0];
        for(int i = 1; i < n; i++)
            pre[i] = pre[i-1]*nums[i];
        
        suff[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--)
            suff[i] = nums[i]*suff[i+1];
        
        int productExceptItself[] = new int[n];
        
        productExceptItself[0] =  suff[1];
        productExceptItself[n-1] = pre[n-2];       
        for(int i = 1; i < n-1; i++)
            productExceptItself[i] = pre[i-1]*suff[i+1];
        
        return productExceptItself;  
    }
}
