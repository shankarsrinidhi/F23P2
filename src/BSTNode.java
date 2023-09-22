//public class BSTNode<K extends Comparable<? super K>, V> implements Node<K, V> {
//    private K key;               // Key for this node
//    private V value;             // Value for this node
//    private BSTNode<K, V> left;  // Pointer to left child
//    private BSTNode<K, V> right; // Pointer to right child
//
//    // Constructors
//    public BSTNode() { left = right = null; }
//    public BSTNode(K key, V value) { 
//        this.key = key;
//        this.value = value;
//        left = right = null;
//    }
//    public BSTNode(K key, V value, BSTNode<K, V> l, BSTNode<K, V> r) {
//        this.key = key;
//        this.value = value;
//        left = l;
//        right = r;
//    }
//
//    // Get and set the key and value
//    public K getKey() { return key; }
//    public V getValue() { return value; }
//    public void setKey(K key) { this.key = key; }
//    public void setValue(V value) { this.value = value; }
//
//    // Get and set the left child
//    public BSTNode<K, V> getLeft() { return left; }
//    public void setLeft(BSTNode<K, V> left) { this.left = left; }
//
//    // Get and set the right child
//    public BSTNode<K, V> getRight() { return right; }
//    public void setRight(BSTNode<K, V> right) { this.right = right; }
//
//    // Check if leaf node
//    public boolean isLeaf() { return (left == null) && (right == null); }
//    @Override
//    public void setLeft(Node<K, V> left) {
//        // TODO Auto-generated method stub
//        
//    }
//    @Override
//    public void setRight(Node<K, V> right) {
//        // TODO Auto-generated method stub
//        
//    }
//}
