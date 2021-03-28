class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] maxFreqAcrossB = new int[26];

        for(String bStr : B) {
            int[] freqCountB = freq(bStr);
            for(int i = 0; i < 26; i++) {
                maxFreqAcrossB[i] = Math.max(maxFreqAcrossB[i], freqCountB[i]);
            }
        }
        for(String aStr : A) {
            int[] freqCountA = freq(aStr);
            boolean flag = true;
            for(int i = 0; i < 26; i++) {
                if(freqCountA[i] < maxFreqAcrossB[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res.add(aStr);
            }
        }
        return res;
    }
    private int[] freq(String s) {
        int []freqCount = new int[26];
        for(char c : s.toCharArray()) {
            freqCount[c-'a']++;
            
        }
        return freqCount;
    }
}
