class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        boolean leftLower;
        int lower;
        int distance;
        while(l < r) {
            if(height[l] > height[r]) {
                leftLower = false;
                lower = height[r];
            } else {
                leftLower = true;
                lower = height[l];
            }
            distance = r - l;
            max = Math.max(max, lower * distance);
            if(leftLower) l++;
            else r--;
        }
        return max;
    }
}