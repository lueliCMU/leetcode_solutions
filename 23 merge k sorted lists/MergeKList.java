
public class MergeKList {
    /**
     * Divide and conquer: we divide all lists into two-pair groups.
     * and merge all groups into new lists (for each group, we will
     * get one new merged list). Do above step again until
     * we get only one list left.
     * 
     * Time O(nlogk) Space O(1)
     * 
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int last = lists.length - 1;
        int i = 0;
        while (last != 0) {
            while (i < last) {
                lists[i] = mergeTwoLists(lists[i], lists[last]);
                i++;
                last--;
            }
            i = 0;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}