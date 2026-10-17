class TreeNode{
    TreeNode[] children = new TreeNode[26];
    boolean endOfword = false;
}

class Trie {
    TreeNode root = new TreeNode();

    public Trie() {
        
    }
    
   

    public void insert(String word) {
        
        TreeNode current = root;

        for ( char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null){
                current.children[index] = new TreeNode();

            }
            current = current.children[index];
            
        }
        current.endOfword = true; 
    }
        
    
    
    public boolean search(String word) {
        
    TreeNode current = root;

    for (char ch : word.toCharArray()) {
        int index = ch - 'a';

        if (current.children[index] == null) {
            return false;
        }

        current = current.children[index];
    }

    return current.endOfword;
}
        
    
    
    public boolean startsWith(String prefix) {
       
    TreeNode current = root;

    for (char ch : prefix.toCharArray()) {
        int index = ch - 'a';

        if (current.children[index] == null) {
            return false;
        }

        current = current.children[index];
    }

    return true;
}
    }


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */