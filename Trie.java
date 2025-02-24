public class Trie {
    private Node head;
    public Trie() {
        this.head = new Node();
    }
    
    public void insert(String word) {
        Node temp = head;

        for(int i = 0 ; i < word.length(); i++) {
            if(!temp.containsKey(word.charAt(i))) {
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
        }

        temp.setEnd();
    }
    
    public boolean search(String word) {
        Node temp = head;

        for(int i = 0 ; i < word.length(); i++) {
            if(!temp.containsKey(word.charAt(i))){
                return false;
            }
            temp = temp.get(word.charAt(i));
        }
        return temp.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node temp = head;

        for(int i = 0 ; i < prefix.length(); i++) {
            if(!temp.containsKey(prefix.charAt(i))){
                return false;
            }
            temp = temp.get(prefix.charAt(i));
        }
        return true;
    }
}

class Node {
    Node[] links = new Node[26];
    boolean flag;


    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch , Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        this.flag = true;
    }
    
    boolean isEnd() {
        return this.flag;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */