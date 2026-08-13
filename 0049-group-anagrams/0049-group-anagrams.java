class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String newStr = new String(arr);

            map.putIfAbsent(newStr, new ArrayList<String>());
            map.get(newStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}