package Question5;

import java.util.Arrays;

public class Question5 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        printLinkedList(node1);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        printLinkedList(node4);

        ListNode res = mergeTwoSortedLists(node1, node4);
        printLinkedList(res);

    }

    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy, l1 = list1, l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
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
        } else if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode list) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (list != null) {
            sb.append(list.val + " ");
            list = list.next;
            count++;
        }
        int[] arr = new int[count];
        String[] strArr = sb.toString().split(" ");
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.valueOf(strArr[i]);
        }

        System.out.println(Arrays.toString(arr));
    }
}


