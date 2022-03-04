package palindromelinkedlist;

public class Solution {
	
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode node = head;
        while(node != null){
        	size++;
        	node = node.next;
        }
        ListNode headCopy = new ListNode(head.val);
        ListNode iterNode = head;
        for (int i = 1; i < size; i++) {
        	iterNode = iterNode.next;
        	ListNode n = new ListNode(iterNode.val, headCopy);
        	headCopy = n;
		}
        ListNode list1 = head;
        ListNode list2 = headCopy;
        for(int i = 0; i < size/2; i++){
        	if(list1.val != list2.val)
        		return false;
        	list1 = list1.next;
        	list2 = list2.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
		ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(1)));
		Solution s = new Solution();
		System.out.println(s.isPalindrome(list1));
	}

}
