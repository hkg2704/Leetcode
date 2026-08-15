class Solution {
    public int longestSubsequence(int[] nums) {
       int xmax = 0;
       int ormax = 0;

       for(int i= 0; i<nums.length; i++)
       {
        xmax ^= nums[i];
        ormax |= nums[i];
       }

       if(xmax != 0) return nums.length;

       return (ormax != 0) ? nums.length - 1 : 0;
    }
}