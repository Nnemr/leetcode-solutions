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
class BSTIterator {
    Queue<Integer> nodes = new LinkedList<>();
    
    private void traverse(TreeNode root){
        if(root == null)
            return;
        traverse(root.left);
        nodes.add(root.val);
        traverse(root.right);
    }
    public BSTIterator(TreeNode root) {
        traverse(root);
    }
    
    public int next() {
        return nodes.poll();
    }
    
    public boolean hasNext() {
        return !nodes.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */