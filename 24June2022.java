Problem : Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

          For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

          Your algorithm should run in O(n) complexity.
  
Solution : 
          class Solution {
              public int longestConsecutive(int[] nums) {
                  Set<Integer> set = new HashSet<>();

                  //Adding the nums in hashset
                  for(int i : nums) 
                      set.add(i);

                  int maxLength = 0;

                  for(int i = 0; i < nums.length; i++) {
                      if(set.contains(nums[i])) {
                          int length = 1;
                          set.remove(nums[i]);

                          int val = nums[i]-1;
                          //Checks the no.of consecutive elements less than nums[i] starting from nums[i]-1
                          while(set.contains(val)) {
                              length++;
                              set.remove(val--);
                          }

                          val = nums[i]+1;
                          //Checks the no.of consecutive elements greater than nums[i] starting from nums[i]+1
                          while(set.contains(val)) {
                              length++;
                              set.remove(val++);
                          }

                          maxLength = Math.max(maxLength, length);
                      }
                  }

                  return maxLength;
              }
}
