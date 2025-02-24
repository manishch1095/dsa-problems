public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        ListNode ans = solution.addTwoNumbers(l1, l2);
        solution.printList(solution.reverseLinkedList(ans.next));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1  = l1;
        ListNode temp2 = l2;

        ListNode ans = new ListNode(-1);
        ListNode curr = ans;

        int carry = 0;
        while(temp1 != null || temp2 != null || carry != 0) {
            int sum = carry;

            if(temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if(temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }

            int nodeVal = sum % 10 ;
            carry = sum / 10;
            curr.next = addNode(ans, nodeVal);
            curr = curr.next;            
        }
        return ans.next;
    }

    public ListNode addNode(ListNode head, int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
        return head;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        
        ListNode temp = reverseLinkedList((head.next));

        head.next.next = head;
        head.next = null;

        return temp;
    }

    public void printList(ListNode head){
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}