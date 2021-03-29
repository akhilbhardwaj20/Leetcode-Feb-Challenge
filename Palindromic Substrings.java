class Solution {
    
    // tc : O(n2)--> since we are itrating each row and column ,... 
    //sc: O(n2) since we have taken a 2d matrix
    public int countSubstrings(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int res = 0;
        
        //base case 1:  length = 1 --> true (diagonal elements)
        
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }
        
        // base case 2 : len = 2 --> char[i] == char[i+1]
        for(int i = 0; i < n-1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if(dp[i][i+1]) {
                res++;
            }
        }
        // general case: len > 2 --> char[s]==char[e] && dp[i+1][j-1] is true
        
        for(int len = 3; len <= n; len++) {
            for(int i=0, j=i+len-1; j<n; i++, j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                if(dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
