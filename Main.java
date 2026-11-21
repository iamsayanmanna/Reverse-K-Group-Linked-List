import java.util.Scanner;

public class Main {

    // Each node stores a value and the address of the next node.
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse the linked list in groups of k nodes.
    static Node reverseKGroup(Node head, int k) {

        // No reversal is needed for an empty list or k = 1.
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node helps us handle changes to the first node.
        Node dummy = new Node(0);
        dummy.next = head;

        // Points to the node just before the current group.
        Node groupPrev = dummy;

        while (true) {

            // Find the last node of the current group.
            Node kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // If there are fewer than k nodes, stop.
            if (kth == null) {
                break;
            }

            // Save the first node after this group.
            Node nextGroup = kth.next;

            // Reverse the current group.
            Node prev = nextGroup;
            Node current = groupPrev.next;

            while (current != nextGroup) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            // Connect the reversed group to the linked list.
            Node oldGroupStart = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldGroupStart;
        }

        // The new head is after the dummy node.
        return dummy.next;
    }

    // Create a linked list from the given values.
    static Node createList(int[] values) {
        Node head = new Node(values[0]);
        Node tail = head;

        for (int i = 1; i < values.length; i++) {
            tail.next = new Node(values[i]);
            tail = tail.next;
        }

        return head;
    }

    // Display the linked list.
    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n < 1 || n > 5000) {
            System.out.println("Number of nodes must be between 1 and 5000.");
            sc.close();
            return;
        }

        int[] values = new int[n];

        System.out.println("Enter " + n + " node values:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();

            if (values[i] < 0 || values[i] > 1000) {
                System.out.println("Node values must be between 0 and 1000.");
                sc.close();
                return;
            }
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        if (k < 1 || k > n) {
            System.out.println("k must be between 1 and " + n + ".");
            sc.close();
            return;
        }

        Node head = createList(values);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("Linked List after reversing in groups of " + k + ":");
        printList(head);

        sc.close();
    }
}
