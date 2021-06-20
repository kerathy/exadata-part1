package Question3.javasolution;

import java.util.Scanner;

public class InsertNode {

    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        node1.next = node2;
//        node2.next = node3;
//        System.out.println("Before adding new node");
//        printLinkedList(node1);
//        System.out.println();
//
//        System.out.println("After adding new node");
//        insertListNode(node1, 4);
//        printLinkedList(node1);
//
//        System.out.println();
//        System.out.println("Get the last node's value");
//        getTailNodeVal(node1);
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Node cur = new Node(scanner.nextInt());
        Node head = cur;

        StringBuilder sb = new StringBuilder();
        sb.append(getTailNodeVal(head));
        sb.append(" ");
        for (int i = 1; i < size; i++) {
            Node node = new Node(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
            sb.append(getTailNodeVal(head));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    public static Node insertListNode(Node head, int val) {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
//        System.out.println("count:" + count);

        Node pre = head;
        for (int i = 0; i < count - 1; i++) {
            pre = pre.next;
        }

        Node newNode = new Node(val);
        pre.next = newNode;
        return head;
    }

    public static void printLinkedList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    public static int getTailNodeVal(Node head) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node.val;
    }

}
