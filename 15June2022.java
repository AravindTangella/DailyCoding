Problem : Given an integer n and a list of integers l, write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform).
  
Solution : class Solution {

              Set<Integer> blacklist;
              List<Integer> whitelist;
              int randomPointer = 0;//It points to and index in whitelist
              int n;//Exclusive upper limit of blacklist[i]

              public Solution(int n, int[] blacklist) {
                  this.n =n;
                  this.blacklist = new HashSet<>();

                  for(int i = 0; i < blacklist.length; i++)
                      this.blacklist.add(blacklist[i]);

                  whitelist = new ArrayList<>();

                  /* Checking if size of blacklist is greater than or equal to n/3 because if it less than that
                  then there are less elements blacklisted and we will be having to add more elements in whitelist which takes more time */
                  if(blacklist.length >= n/3) {
                      for(int i = 0; i < n; i++) {
                          if(!(this.blacklist.contains(i)))
                              whitelist.add(i);
                      }
                  }
              }

              public int pick() {
                  //If randomPointer reaches end of whitelist then re-pointing it to 0.
                  if(randomPointer == whitelist.size())
                      randomPointer = 0;

                  int randomInt;

                  /*This condition is satisfied whenever there are less elements blacklisted and then we use Random class to return int that
                    doesn't exist in blacklist*/
                  if(whitelist.size() == 0) {
                      while(true) {
                          Random r = new Random();
                          randomInt = r.nextInt(n);
                          if(!blacklist.contains(randomInt))
                              return randomInt;
                      }
                  }

                  randomInt = whitelist.get(randomPointer++);

                  return randomInt;
              }
          }

          /**
           * Solution object will be instantiated and called as such:
           * Solution obj = new Solution(n, blacklist);
           * int param_1 = obj.pick();
           */
