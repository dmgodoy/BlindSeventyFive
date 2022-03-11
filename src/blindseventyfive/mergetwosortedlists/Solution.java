package blindseventyfive.mergetwosortedlists;

import blindseventyfive.utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class Result {
        ListNode last;
        ListNode node1;
        ListNode node2;
        Result(ListNode last, ListNode node1, ListNode node2){
            this.last = last;
            this.node1 = node1;
            this.node2 = node2;
        }
    }
    Result compare(ListNode n1, ListNode n2){
        ListNode node1 = n1;
        ListNode node2 = n2;
        if(node1.val < node2.val){
            return new Result(node1, node1.next, node2);
        }
        return new Result(node2, node1, node2.next); 
        
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        Result r = compare(list1, list2);
        ListNode mergedHead = r.last;
        ListNode last = r.last;
        ListNode n1 = r.node1;
        ListNode n2 = r.node2;
        
        while(n1 != null && n2 != null){
            Result r1 = compare(n1, n2);
            last.next = r1.last;
            last = r1.last;
            n1 = r1.node1;
            n2 = r1.node2;
        }
        if(n1 == null)
            last.next = n2;
        if(n2 == null)
            last.next = n1;
        
        return mergedHead;
    }
}