class Solution {
    public int longestSubsequence(int[] nums) {
       int xmax = 0;
       int ormax = 0;

       for(int num : nums)
       {
        xmax ^= num;
        ormax |= num;
       }

       if(xmax != 0) return nums.length;

       return (ormax != 0) ? nums.length - 1 : 0;
    }
}