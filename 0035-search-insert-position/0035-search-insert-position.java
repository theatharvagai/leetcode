class Solution {
    public int searchInsert(int[] nums, int target) {
        int startIdx = 0;
        int endIdx=nums.length-1;
        
        while(startIdx <= endIdx){
            int midPoint = startIdx + (endIdx - startIdx) / 2;
            
            if(nums[midPoint] == target) {
                return midPoint;
            } else if (nums[midPoint] < target) {
                startIdx = midPoint + 1;
            } else{
                endIdx = midPoint - 1;
            }
        }
        
        return startIdx;
    }
}