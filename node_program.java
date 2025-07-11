import java.util.Scanner;
import java.util.Stack;

public class node_program {
    public static void main(String[] args) {
        Reverse print = new Reverse();
        print.print_data();
    }
}

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Reverse {
    Stack<Character> stack = new Stack<>();

    public void print_data() {
        Node head = null, current = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("何回入力します？");
        int num = Integer.parseInt(scan.nextLine());
        System.out.println("1文字づつ入力してください");
        for (int i = 1; i <= num; i++) {
            char enter_data = scan.nextLine().charAt(0);
            Node new_node = new Node(enter_data);
            if (head == null) {
                head = new_node;
                current = head;
            } else {
                current.next = new_node;
                current = new_node;
            }
        }
        reverse_change(head);
        get_reverse_data();
        scan.close();
    }

    private void reverse_change(Node node) {
        if (node != null) {
            stack.push(node.data);
            reverse_change(node.next);
        }
    }

    private void get_reverse_data() {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
