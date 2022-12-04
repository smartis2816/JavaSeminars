package homework_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Homework6 {
    public static void main(String[] args) {
        Node n1 = new Node('F');
        Node n2 = new Node('B');
        Node n3 = new Node('G');
        Node n4 = new Node('A');
        Node n5 = new Node('D');
        Node n6 = new Node('I');
        Node n7 = new Node('C');
        Node n8 = new Node('E');
        Node n9 = new Node('H');
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n5.right = n8;
        n3.right = n6;
        n6.left = n9;

        // В качестве ДЗ реализовано несколько методов по обходу дерева в глубину и в ширину
        System.out.print("Pre-Order: ");
        bypassPreOrder(n1);
        System.out.println();
        System.out.print("Post-Order: ");
        bypassPostOrder(n1);
        System.out.println();
        System.out.print("In-Order: ");
        bypassInOrder(n1);
        System.out.println();
        System.out.print("Reverse Pre-Order: ");
        bypassReversePreOrder(n1);
        System.out.println();
        System.out.print("Reverse Post-Order: ");
        bypassReversePostOrder(n1);
        System.out.println();
        System.out.print("Reverse In-Order: ");
        bypassReverseInOrder(n1);
        System.out.println();
        System.out.print("Level-Order: ");
        bypassLevelOrder(n1);

    }

    public static void bypassPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + "  ");
            bypassPreOrder(node.left);
            bypassPreOrder(node.right);
        }
    }

    public static void bypassPostOrder(Node node) {
        if (node != null) {
            bypassPostOrder(node.left);
            bypassPostOrder(node.right);
            System.out.print(node.value + "  ");
        }
    }

    public static void bypassInOrder(Node node) {
        if (node != null) {
            bypassPostOrder(node.left);
            System.out.print(node.value + "  ");
            bypassPostOrder(node.right);
        }
    }

    public static void bypassReversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + "  ");
            bypassPreOrder(node.right);
            bypassPreOrder(node.left);
        }
    }

    public static void bypassReversePostOrder(Node node) {
        if (node != null) {
            bypassPostOrder(node.right);
            bypassPostOrder(node.left);
            System.out.print(node.value + "  ");
        }
    }

    public static void bypassReverseInOrder(Node node) {
        if (node != null) {
            bypassPostOrder(node.right);
            System.out.print(node.value + "  ");
            bypassPostOrder(node.left);
        }
    }

    public static void bypassLevelOrder(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            Node n = nodes.remove();
            System.out.print(n.value + "  ");
            if (n.left != null) {
                nodes.add(n.left);
            }
            if (n.right != null) {
                nodes.add(n.right);
            }
        }
    }
}

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}