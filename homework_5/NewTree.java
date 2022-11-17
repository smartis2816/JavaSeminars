package homework_5;


public class NewTree {
    static Node root;

    public static void main(String[] args) {
        NewTree myTree = createTree();
        bypass(root);
    }

    public Node insert(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insert(current.left, value);
        } else {
            current.right = insert(current.right, value);
        }
        return current;
    }

    public void add(int value) {
        root = insert(root, value);
    }

    public static NewTree createTree() {
        NewTree tree = new NewTree();
        int[] values = {5, 7, 9, 4, 6, 3, 0, 1, 8, 2};
        for (int item : values) {
            tree.add(item);
        }
        return tree;
    }

    public static void bypass(Node node) {
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            sb.append(node.value);
            sb.append("\n");
            System.out.print(sb);
            bypass(node.left);
            bypass(node.right);
        }
    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

}
