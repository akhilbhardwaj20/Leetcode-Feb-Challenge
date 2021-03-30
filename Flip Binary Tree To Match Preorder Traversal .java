/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// TC-O(N) since we are visiting all the nodes once
// SC- O(log n) where n is the no of nodes 
class Solution {
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
       
        if(dfs(root, voyage, res)) {
            return res;
        } else {
            List<Integer> rejectCase = new ArrayList<>();
            rejectCase.add(-1);
            return rejectCase;
        }
    }
    private boolean dfs(TreeNode root, int[] voyage, List<Integer> res) {
        if(root == null) {
            return true;
        }
        if(root.val != voyage[i]) {
            return false;
        } else {
            i++;
        }
        if(root.left != null && root.left.val != voyage[i]) {
            res.add(root.val);
            // apply dfs in reverse fashion --> right--left
            return dfs(root.right, voyage, res) && dfs(root.left, voyage, res);
        } else {
            return dfs(root.left, voyage, res) && dfs(root.right, voyage, res);
        }
    }
}
