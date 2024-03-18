class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] countChar = new int[26];
        for(char c : s.toCharArray()) {
            countChar[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            if(countChar[c - 'a'] == 0) return false;
            countChar[c - 'a']--;
        }

        return true;
    }
}