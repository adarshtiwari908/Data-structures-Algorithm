class Solution{
     public void deleteNode(ListNode node){
        //copy the value of next node into current node 
        node.val = node.next.val;
        //skip the next node
        node.next = node.next.next;
     }
}