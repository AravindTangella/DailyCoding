Problem 1 : Given a number in the form of a list of digits, return all possible permutations.

            For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].
  
Solution :
            class Solution {
                public List<List<Integer>> permute(int[] nums) {
                    //Stores all permutations of given array
                    List<List<Integer>> permutations = new ArrayList<>();

                    //Stores the current permutation
                    List<Integer> currentPermutation = new ArrayList<>();

                    //Marks elements in currentPermutation as visited as they should not be considered again
                    boolean visited[] = new boolean[nums.length];

                    computePermutations(nums, currentPermutation, visited, permutations);

                    return permutations;
                }

                public void computePermutations(int[] nums, List<Integer> currentPermutation, boolean[] visited,
                                        List<List<Integer>> permutations) {
                    if(currentPermutation.size() == nums.length) {
                        permutations.add(new ArrayList<>(currentPermutation));
                        return;
                    }

                    //At any point, all elements that has not been visited should be considered at that point
                    for(int i = 0; i < visited.length; i++) {
                        if(!visited[i]) {
                            currentPermutation.add(nums[i]);//Adding the element in current path           
                            visited[i] = true;//Marking it as visited

                            computePermutations(nums, currentPermutation, visited, permutations);

                            // Removing the element from current path as it should be available for next permutation
                            currentPermutation.remove(currentPermutation.size()-1);
                            visited[i] = false;//Unmarking the current element as it is no longer available in the path
                        }
                    }
                }
            }
