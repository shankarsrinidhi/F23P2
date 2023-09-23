public class BST<K extends Comparable<K>> {
    private Node<K> root;
 // Counter to keep track of the number of nodes
    private int nodeCount; 
    
    public BST() {
        this.root = null;
        this.nodeCount = 0;
    }


    private static class Node<K extends Comparable<K>> {
     // KVPair object to hold key-value pair
        KVPair<K> kvPair;
        Node<K> left;
        Node<K> right;

        Node(K key, Object value) {
            this.kvPair = new KVPair<>(key, value);
        }
    }
    //insert operation

    public void insert(K key, Object value) {
        root = insert(root, new KVPair<>(key, value));
        nodeCount++;
    }


    private Node<K> insert(Node<K> node, KVPair<K> kvPair) {
        if (node == null) {
            return new Node<>(kvPair.getKey(), kvPair.getValue());
        }

        int cmp = kvPair.getKey().compareTo(node.kvPair.getKey());
        if (cmp <= 0) {
            node.left = insert(node.left, kvPair);
        } else {
            node.right = insert(node.right, kvPair);
        }

        return node;
    }

    // Search operation
    public Object search(K key) {
        return search(root, key);
    }

    private Object search(Node<K> node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.kvPair.getKey());
        if (cmp < 0) {
            return search(node.left, key);
        } else if (cmp > 0) {
            return search(node.right, key);
        } else {
            return node.kvPair.getValue();
        }
    }

    //remove operation
    public void remove(K key, int id) {
        root = remove(root, key, id);
        if (root != null) {
            nodeCount--; // Only decrement if a node was actually removed
        }
    }


    private Node<K> remove(Node<K> node, K key, int id) {
        if (node == null) return null;

        int cmp = key.compareTo(node.kvPair.getKey());
        if (cmp < 0) {
            node.left = remove(node.left, key, id);
        } else if (cmp > 0) {
            node.right = remove(node.right, key, id);
        } else {
         // cmp == 0, key is equal
            if (node.kvPair.getId() == id) {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;

                Node<K> temp = node;
                node = max(node.left);
                node.left = deleteMax(temp.left);
                node.right = temp.right;
            } else {
                // If the ID doesn't match, continue searching in the left subtree
                // You may choose to search in the right subtree based on your requirements
                node.left = remove(node.left, key, id);
            }
        }
        return node;
    }

    private Node<K> max(Node<K> node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    private Node<K> deleteMax(Node<K> node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        return node;
    }
    public int getNodeCount() {
        return nodeCount;
    }
    public void printTree() {
        printTree(root);
    }

    private void printTree(Node<K> node) {
        if (node == null) return;

        printTree(node.left);
        System.out.println(node.kvPair);
        printTree(node.right);
    }

    public void printNodesInRange(K low, K high) {
        printNodesInRange(root, low, high);
    }

    private void printNodesInRange(Node<K> node, K low, K high) {
        if (node == null) return;

        int cmpLow = low.compareTo(node.kvPair.getKey());
        int cmpHigh = high.compareTo(node.kvPair.getKey());

        if (cmpLow < 0) {
            printNodesInRange(node.left, low, high);
        }

        if (cmpLow <= 0 && cmpHigh >= 0) {
            System.out.println(node.kvPair);
        }

        if (cmpHigh > 0) {
            printNodesInRange(node.right, low, high);
        }
    }
}
