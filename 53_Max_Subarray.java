class Solution {
    public int maxSubArray(int[] nums) {
        // dp record the max subarray ending with nums[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // if previous sum is less than 0,
            // then max subarray ending with nums[i] is itself
            dp[i] = dp[i - 1] > 0 ? (dp[i - 1] + nums[i]) : (nums[i]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}

// Solution 2:

//similar idea with dp
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        // keep track dp array with only one number
        int end = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            end = Math.max(end + nums[i], nums[i]);
            max = Math.max(max, end);
        }
        
        return max;
    }
}