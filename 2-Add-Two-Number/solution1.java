
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    
   
       Overview 
   
   
          Time 2ms (99.44%)
           Memory 47.8MB(48.72%)
   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        
        boolean offset = false;
        while(l1 != null  l2 != null){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(offset){
                sum += 1;
                offset = false;
            }
            if(sum  9){
                offset = true;
                sum -= 10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
        }
        
        if(offset){
            temp.next = new ListNode(1);
        }
        return res.next;
        
    }
    
    
}