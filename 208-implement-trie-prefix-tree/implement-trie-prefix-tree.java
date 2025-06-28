class Node{
    Node[] children ;
    boolean isleaf;
    Node(){
        children = new Node[26];
        isleaf=false;
    }
}
class Trie {
Node root;
    public Trie() {
      root = new Node();
    }
    
    public void insert(String word) {
        Node curr=root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new Node();
            }
            curr=curr.children[c-'a'];
        }
        curr.isleaf=true;
    }
    
    public boolean search(String word) {
      Node curr=root;
      
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isleaf;
    }
    
    public boolean startsWith(String prefix) {
                Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
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