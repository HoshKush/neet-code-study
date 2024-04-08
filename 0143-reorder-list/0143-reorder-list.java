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
    ListNode[] l = new ListNode[5 * 10000];
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode cur = head;
        l[0] = new ListNode(head.val);
        int idx = 1;
        while(cur.next != null) {
            l[idx] = new ListNode(cur.next.val);
            cur = cur.next;
            idx++;
        }

        cur = head;
        for(int i = 1; i < idx; i++) {
            if(i % 2 == 0) {
                cur.next = l[i / 2];
                cur = cur.next;
                continue;
            }
            cur.next = l[idx - 1 - (i / 2)];
            cur = cur.next;
        }
    }
}