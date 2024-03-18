class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int p = 1;
        int idxOfZero = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(idxOfZero != -1)  return answer;
                idxOfZero = i;
                continue;
            }
            p *= nums[i];
        }
        
        if(idxOfZero != -1) {
            answer[idxOfZero] = p;
            return answer;
        }
        
        for(int i = 0; i < nums.length; i++) {
            answer[i] = p / nums[i];
        }
        
        return answer;
    }
}