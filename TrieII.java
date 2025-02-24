

public class TrieII {
    private Node head;

    public TrieII() {
        this.head = new Node();
    }
    
    public void insert(String word) {
        Node temp = head;

        for(int i = 0 ; i < word.length(); i++) {
            if(!temp.containsKey(word.charAt(i))) {
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
            temp.incrementPrefixCount();
        }
        temp.incrementCount();
    }

    public int countWordsEqualTo(String word) {
        Node temp = head;

        for(int i = 0 ; i < word.length(); i++) {
            if(!temp.containsKey(word.charAt(i))){
                return 0;
            }
            temp = temp.get(word.charAt(i));
        }
        return temp.endCount;
    }

    public int countWordsStartingWith(String word) {
        Node temp = head;

        for(int i = 0 ; i < word.length(); i++) {
            if(!temp.containsKey(word.charAt(i))){
                return 0;
            }
            temp = temp.get(word.charAt(i));
        }
        return temp.prefixCount;
    }

    public void erase(String word) {
        Node temp = head;

        for(int i = 0 ; i < word.length(); i++) {
            if(!temp.containsKey(word.charAt(i))){
                return;
            }
            temp = temp.get(word.charAt(i));
            temp.decrementPrefixCount();
        }
       temp.decrementCount();
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
    int endCount;
    int prefixCount;


    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch , Node node) {
        links[ch - 'a'] = node;
    }
    
    boolean isEnd() {
        return this.endCount > 0;
    }

    void incrementCount() {
        this.endCount = this.endCount + 1;
    }

    void decrementCount() {
        this.endCount = this.endCount - 1;
    }

    void incrementPrefixCount() {
        this.prefixCount = this.prefixCount + 1;
    }

    void decrementPrefixCount() {
        this.prefixCount = this.prefixCount - 1;
    }

}