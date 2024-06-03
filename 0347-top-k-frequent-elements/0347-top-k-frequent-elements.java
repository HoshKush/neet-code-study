class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> counted = IntStream.of(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counted.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .mapToInt(Map.Entry::getKey)
            .limit(k)
            .toArray();
    }
}