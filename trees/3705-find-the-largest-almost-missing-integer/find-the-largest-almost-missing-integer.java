class Solution {
    public int largestInteger(int[] nums, int k) {
        int numbers[]=new int[51];
        
        for(int right =k-1;right<nums.length;right++)
        {boolean seen[]=new boolean[51];
            for(int left=right-k+1;left<=right;left++){seen[nums[left]]=true;}
            for(int i=0;i<=50;i++)
            {
                if(seen[i]){numbers[i]++;}
            }
            
        }
        for(int i=50;i>=0;i--){if(numbers[i]==1)return i;}
        return -1;
    }
}