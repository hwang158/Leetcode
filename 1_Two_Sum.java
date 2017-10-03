class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (rec.containsKey(nums[i])) {
                res[0] = rec.get(nums[i]);
                res[1] = i;
                return res;
            }
            rec.put(target - nums[i], i);
        }

        // Don't forget return res
        return res;
    }
}