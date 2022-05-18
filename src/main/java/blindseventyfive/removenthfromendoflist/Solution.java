package blindseventyfive.removenthfromendoflist;

import blindseventyfive.utils.ListNode;

class Solution {
    int countNodes(ListNode node){
        int size = 0;
        while(node != null){
            node = node.next;
            size++;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = countNodes(head);
        //assert(n > size || n <= 0);
        if(n > size) n = size;
        int index = size - n; // index from head starting from 0
        if(index == 0)
            return head.next;
        ListNode node = head;
        int count = 0;
        while(count + 1 < index){
            node = node.next;
            count++;
        }
        node.next = node.next.next;
        return head;
    }
}