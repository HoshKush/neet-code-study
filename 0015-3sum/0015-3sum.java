class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> answer = new ArrayList<>();
    HashMap<Integer, Integer> count = new HashMap<>();
    for(int i : nums) {
      if(count.containsKey(i)) {
        count.put(i, count.get(i) + 1);
        continue;
      }
      count.put(i, 1);
    }
    int target;
    List<Integer> keys = new ArrayList<>(count.keySet());
    Collections.sort(keys);
    for(int i = 0; i < keys.size() - 1; i++) {
      for(int j = i + 1; j < keys.size(); j++) {
        target = (keys.get(i) + keys.get(j)) * -1;
        if(target == keys.get(i) || target == keys.get(j)) { // -1, -1, 2
          if(count.getOrDefault(target,0) >= 2) {
            answer.add(triplet(keys.get(i), keys.get(j), target));
          }
          continue;
        }
        if (target > keys.get(j) && count.containsKey(target)) {
          answer.add(triplet(keys.get(i), keys.get(j), target));
        }
      }
    }
    if(count.getOrDefault(0, 0) >= 3) answer.add(triplet(0, 0, 0));
    return answer;
  }

  public List<Integer> triplet(int i, int j, int k) {
    List<Integer> l = new ArrayList<>();
    l.add(i);
    l.add(j);
    l.add(k);
    return l;
  }
}