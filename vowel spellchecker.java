class Solution {
    
    // tc : O(no of queries + no of elements in wordlist * 2)
    // sc: O(n) where n = length of wordlist
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordSet = new HashSet<>();
        for(String word: wordlist) {
            wordSet.add(word);
        }
        HashMap<String,String> map = new HashMap<>();
        for(String word: wordlist) {
            String lowerCaseStr = word.toLowerCase();
            map.putIfAbsent(lowerCaseStr, word);
            
            String vowelRemovedStr = getvowelRemovedStr(word);
            map.putIfAbsent(vowelRemovedStr, word);
        }
        for(int i = 0; i < queries.length; i++) {
            if(wordSet.contains(queries[i])) {
                continue;
            }
            String lowerCaseQuery = queries[i].toLowerCase();
            if(map.containsKey(lowerCaseQuery)) {
                queries[i] = map.get(lowerCaseQuery);
                continue;
            }
            String vowelRemovedQuery = getvowelRemovedStr(queries[i]);
            if(map.containsKey(vowelRemovedQuery)) {
                queries[i] = map.get(vowelRemovedQuery);
                continue;
            }
            queries[i] = ""; 
        }
        return queries;
    }
    
    private String getvowelRemovedStr(String word) {
        char wordChar[] = word.toLowerCase().toCharArray();
        for(int i = 0; i < word.length(); i++) {
            if(wordChar[i] == 'a' || wordChar[i] == 'e' || wordChar[i] == 'i' || 
              wordChar[i] == 'o' || wordChar[i] == 'u' ) {
                wordChar[i] = '*';
            }
        }
        return new String(wordChar);
    }
}
