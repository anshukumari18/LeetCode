class Solution {
  public int lengthOfLongestSubstring(String s) {
    int max = 0, left = 0;
    HashMap<Character, Integer> map = new HashMap<>(); // char → last index
    for (int right = 0; right < s.length(); right++) {
      if (map.containsKey(s.charAt(right)))
        left = Math.max(left, map.get(s.charAt(right)) + 1); // jump left past dup
      map.put(s.charAt(right), right);
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}