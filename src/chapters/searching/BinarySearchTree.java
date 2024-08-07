package chapters.searching;

/**
 * @author Nane Petrosyan
 * 07.08.24
 */
public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }

    private class Node {
        private int key;
        private String value;
        private Node left;
        private Node right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private String get(int key) {
        return this.get(root, key);
    }

    private String get(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.getKey() == key) {
            return root.getValue();
        }

        if (root.getKey() > key) get(root.getLeft(), key);
        else get(root.getRight(), key);

        return null;
    }

    private void put(int key, String value) {
        this.root = put(this.root, key, value);
    }

    private Node put(Node root, int key, String value) {
        if (root == null) {
            return new Node(key, value);
        }

        if (root.getKey() > key) root.setLeft(put(root.getLeft(), key, value));
        else if (root.getKey() < key) root.setRight(put(root.getRight(), key, value));
        else root.setValue(value);

        return root;
    }

    public static void main(String[] args) {
        final BinarySearchTree bst = new BinarySearchTree();
        bst.put(2, "Two");
        bst.put(3, "Three");
        bst.put(8, "Eight");
        bst.put(4, "Four");
        bst.get(2);
    }
}
