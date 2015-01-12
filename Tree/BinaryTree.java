 
public class BinaryTree {
    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    } 
    
	// pre-order traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode p = root;
        
        while (true) {
            while (p != null) {
                list.add(p.val);
                if (p.right != null) {
                    st.push(p.right);
                }
                p = p.left;
            }
            
            if (st.isEmpty()) {
                break;
            } else {
                p = st.pop();
            }
        }
        
        return list;
    }
	
	// in-order traversal
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while (true) {
            if (p != null) {
                st.push(p);
                p = p.left;
            } else if (!st.isEmpty()) {
                p = st.pop();
                list.add(p.val);
                p = p.right;
            } else {
                break;
            }
        }
        
        return list;
    }
	
	// post-order traversal
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) { // always check the null root first
            return list;
        }
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = null, last = null;
        st.push(root);
        
        while (!st.isEmpty()) {
            p = st.peek();
            if (last == null || p == last.left || p == last.right) {
                if (p.left != null) { // push the left OR right node, NOT both!
                    st.push(p.left);
                } else if (p.right != null) {
                    st.push(p.right);
                }
            } else if (p.left == last) { // reverse from the left
                if (p.right != null) {
                    st.push(p.right);
                }
            } else {
                list.add(p.val);
                st.pop();
            }
            last = p; // update the previous node
        }
        
        return list;
    }
	
	
	
}