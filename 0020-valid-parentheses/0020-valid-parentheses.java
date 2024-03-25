class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('{', '}');
        pair.put('[', ']');
        char[] p = new char[s.length()];
        int idx = 0;
        for(char c : s.toCharArray()) {
            if(!pair.containsKey(c)) {
                if(idx == 0) return false;
                if(pair.get(p[idx - 1]) != c) return false;
                idx--;
                continue;
            }
            p[idx] = c;
            idx++;
        }
        return idx == 0;
    }
}