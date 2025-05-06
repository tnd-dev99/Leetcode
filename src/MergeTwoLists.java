public class MergeTwoLists {
    MergeTwoLists(){
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3, null);
        ListNode l13 = new ListNode(-9, l12);

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(7, null);
        ListNode l23 = new ListNode(5, l22);

        ListNode listNode = mergeTwoLists(l13, l23);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        int startNum = list1.val <= list2.val ? list1.val - 1 : list2.val - 1;

        ListNode headNode = new ListNode(startNum);
        ListNode current = headNode;
        while (list1 != null || list2 != null){
            if(list1 == null){
                current.next = list2;
                break;
            } else if (list2 == null) {
                current.next = list1;
                break;
            }else if(current.val <= list1.val && list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            }else if(current.val <= list1.val && list1.val > list2.val){
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        }
        return headNode.next;
    }
}
