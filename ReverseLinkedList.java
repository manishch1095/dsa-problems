

public class ReverseLinkedList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node = solution.reverseLinkedList(node);
        solution.printList(node);
    }
}
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}


class Solution {
    public Node reverseLinkedList(Node head) {
        if(head == null || head.next == null) 
            return head;
        
        Node temp = reverseLinkedList((head.next));

        head.next.next = head;
        head.next = null;

        return temp;
    }

    public void printList(Node head){
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}