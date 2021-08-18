/Time complexity - O(n^3)
//Space complexity O(n*n)

class Solution {
    public int maxCoins(int[] nums) {
      if(nums == null || nums.length == 0) return 0;
      //length of the dp array
      int n = nums.length;
      int [][] dp = new int[n][n];
      // take length single sub array, pair, triplet and four elemnts
      for(int len = 1; len <= n; len++) {
        //take sub arrays 
        //end of the arr n-length of the sub array
        for(int i = 0; i<= n-len;i++){
          //last index of sub array is i+len-1
            int j = i+len-1;
          //traverse sub array
          for(int k = i; k<=j; k++) {
            int after = 0;
            int before = 0;
            //format to calculate coins.. 
            /*coins for balloons busrsted before+ remaining left of the current *current*remaining         right of the current +coins for balloons busrsted after*/

            if(k != i) {
              before = dp[i][k-1];
            } 
            if(k != j) {
              after = dp[k+1][j];
            }
            int left = 1;
            int right = 1;
            if(i!=0){
              left = nums[i-1];
            } 
            if(j !=n-1) {
              right = nums[j+1];
            }
            dp[i][j] = Math.max(dp[i][j] , before+left *nums[k]* right+after);
          }
        }
      }
        return dp[0][n-1];
    }
}