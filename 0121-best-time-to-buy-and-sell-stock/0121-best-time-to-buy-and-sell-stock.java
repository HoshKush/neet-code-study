class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int min = prices[0];
        int answer = 0;
        for (int i = 1; i < prices.length; i++) {
            if(min < prices[i]) {
                if (prices[i] - min > answer)
                    answer = prices[i] - min;
            } else {
                min = prices[i];
            }
        }

        return answer;  
    }
}