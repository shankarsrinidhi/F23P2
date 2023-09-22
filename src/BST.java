public class BST<K extends Comparable<K>, V> {
    private BSTNode<K, V> root;
    private int nodecount;

    // Constructor
    public BST() {
        root = null;
        nodecount = 0;
    }

    // Clear the tree
    public void clear() {
        root = null;
        nodecount = 0;
    }

    // Insert a new value into the BST
    public void insert(K key, V value) {
        root = inserthelp(root, key, value);
        nodecount++;
    }

    private BSTNode<K, V> inserthelp(BSTNode<K, V> node, K key, V value) {
        if (node == null) {
            return new BSTNode<>(key, value);
        }

        int cmp = key.compareTo(node.key);
        
        if (cmp < 0) {
            node.left = inserthelp(node.left, key, value);
        } else if (cmp > 0) {
            node.right = inserthelp(node.right, key, value);
        }
        return node;
    }

    // Find a value in the BST
    public V find(K key) {
        return findhelp(root, key);
    }

    private V findhelp(BSTNode<K, V> node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return findhelp(node.left, key);
        } else if (cmp > 0) {
            return findhelp(node.right, key);
        } else {
            return node.value;
        }
    }

    // Remove a value from the BST
    public V remove(K key) {
        V temp = findhelp(root, key);
        if (temp != null) {
            root = removehelp(root, key);
            nodecount--;
        }
        return temp;
    }

    private BSTNode<K, V> removehelp(BSTNode<K, V> node, K key) {
        if (node == null) return null;
        
        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = removehelp(node.left, key);
        } else if (cmp > 0) {
            node.right = removehelp(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            BSTNode<K, V> temp = node;
            node = getMax(temp.left);
            node.left = deleteMax(temp.left);
            node.right = temp.right;
        }
        return node;
    }

    private BSTNode<K, V> getMax(BSTNode<K, V> node) {
        if (node.right == null) return node;
        return getMax(node.right);
    }

    private BSTNode<K, V> deleteMax(BSTNode<K, V> node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        return node;
    }

    // Get the size of the BST
    public int size() {
        return nodecount;
    }

    // Add the BSTNode class (consider making this static or moving it to a separate file)
    public static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left, right;

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
