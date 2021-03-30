class Solution {
    
    // TC - O(N2)
    // SC - O(N) - no. of envelopes
    public int maxEnvelopes(int[][] envelopes) {
        int maxEn = 1;
        
        Arrays.sort(envelopes, (a,b) -> (a[0]-b[0])); // sort the array on the basis of width
        int len = envelopes.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i = 0; i < len; i++) {  // i->[0,len)
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {  // 0- wi 1 - hei
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }   
            }
            maxEn = Math.max(maxEn,dp[i]);
        }
        return maxEn;
    }
}
