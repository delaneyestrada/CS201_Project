package study;

public class BinarySearchTree {

    // creates the structure of a Node
    class Node {
        String key;
        String value;
        Node left, right;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    // instantiates root node
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls recursiveInsert()()
    void insert(String key, String value) {
        root = recursiveInsert(root, key, value);
    }

    // recursively inserts a new key into binary search tree
    Node recursiveInsert(Node root, String key, String value) {

        if (root == null) {
            root = new Node(key,value);
            return root;
        }

        if ((key.compareToIgnoreCase(root.key)) < 0)
            root.left = recursiveInsert(root.left, key, value);
        else if ((key.compareToIgnoreCase(root.key)) >= 0 )
            root.right = recursiveInsert(root.right, key,value);

        // returns root node
        return root;
    }


    // recursively searches for a key in binary search tree
    public Node search(Node root, String key)
    {
        // if root is null or key is the root value returns root
        if (root==null || root.key.equalsIgnoreCase(key)) {
            return root;
        }
        // returns left node if value is greater then root's key
        else if (root.key.compareToIgnoreCase(key) > 0) {
            return search(root.left, key);
        } else {
            // returns right node if value is less than root's key
            return search(root.right, key);
        }
    }
}