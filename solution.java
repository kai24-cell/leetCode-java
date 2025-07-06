public class solution {
    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // 465 -> 5 → 6 → 4
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        deal solution = new deal();
        Node result = solution.addTwoNumbers(l1, l2);

        // 出力: 7 → 0 → 8
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null)
                System.out.print(" → ");
            result = result.next;

        }
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class deal {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy_head = new Node(0);
        Node current_head = dummy_head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10; // 繰り上がり
            current_head.next = new Node(sum % 10); // 1桁ずつ入れる
            current_head = current_head.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy_head.next;
    }
}