import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbers {

    AddTwoNumbers(){
        //list 1
        ListNode l11 = new ListNode(3, null);
        ListNode l12 = new ListNode(5, l11);
        ListNode l13 = new ListNode(1, l12);
        //list2
        ListNode l21 = new ListNode(4, null);
        ListNode l22 = new ListNode(6, l21);
            ListNode l23 = new ListNode(5, l22);

        ListNode listNode = addTwoNumbers(l13, l23);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    /**
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * 7 - next 0
     * 0 - next 8
     * 8 - next null
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prevNode = null, newNode = null, headNode = null;
        int carry = 0, unit = 0, i = 0;
        while(l1 != null || l2 != null || carry > 0){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            if(val1 + val2 + carry > 9){
                unit = Math.abs(val1 + val2 + carry - 10);
                carry = 1;
            }else {
                unit = val1 + val2 + carry;
                carry = 0;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            prevNode = newNode;
            newNode = new ListNode(unit, null);
            if(i == 0) headNode = newNode;

            if(prevNode != null){
                prevNode.next = newNode;
            }
            i++;
        }
        return headNode;
    }
}
