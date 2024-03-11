class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(s.isEmpty()) return true;
        char[] cArr = s.toCharArray();

        int b = 0;
        int e = cArr.length - 1;
        while(b <= e) {
            if(cArr[b] != cArr[e]) return false;
            b++;
            e--;
        }

        return true;
    }
}