class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        for(String str : strs){
            String sortedString = sortTheString(str);
            ArrayList<String> list = hm.get(sortedString);
            if(list == null){
                list = new ArrayList<String>();
            }
            list.add(str);
            hm.put(sortedString,list);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : hm.keySet()){
            res.add(hm.get(key));
        }
        return res;
    }
    private String sortTheString(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray()){
            freq[ch - 'a']++;
        }
        StringBuilder res = new StringBuilder("");
        for(int i = 0 ; i < 26 ; i++){
            while(freq[i]-- != 0){
                res.append((char)(i + 'a'));
            }
        }
        return res.toString();
    }
}