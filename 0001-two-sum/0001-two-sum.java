class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> positive = new HashMap<>(); // hashMap의 최대 크기 2의 30승 (1억개가 조금 넘음)

        int n, t;
        int[] answer = new int[2];
        for(int i = 0; i < nums.length; i++) {
            n = nums[i];
            t = target - n;
            if(positive.containsKey(t)) {
                answer[0] = positive.get(t);
                answer[1] = i;
                break;
            }

            

            positive.put(n, i);
        }

        return answer;
    }
}