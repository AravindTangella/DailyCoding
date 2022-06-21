Problem 1 : Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering. 
            If there is not greater permutation possible, return the permutation with the lowest value/ordering.

          For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. The list [3,2,1] should return [1,2,3].

          Can you perform the operation without allocating extra memory (disregarding the input memory)?
Solution : 
            class Solution {
                public void nextPermutation(int[] nums) {
                    if(nums.length == 1)
                        return;

                    int i;
                    //Finding the first element nums[i] where nums[i] >= nums[i+1] from the end
                    for(i = nums.length-2; i >= 0; i--) {
                        if(nums[i] < nums[i+1])
                            break;
                    }
                    int j = nums.length-1;
                    //Starting from end, finding first element nums[j] > nums[i] and then we swap.
                    if(i >= 0) {
                        while(nums[i] >= nums[j])
                            j--;
                        swap(nums, i++, j);
                    } 

                    j = nums.length-1;
                    //Sorts elements to the right of nums[i] in ascending order if i >= 0
                    if(i >= 0) {
                        while(i < j) 
                            swap(nums, i++, j--);
                    }
                    /* List has the largest permutation possible so we just make the whole list in ascending order by reversing it to               
                      return the least permutation possible */ 
                    else {
                        i = 0;
                        while(i < j)
                            swap(nums, i++, j--);
                    }

                }

                public void swap(int[] nums, int i, int j) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;        
                }
            }
