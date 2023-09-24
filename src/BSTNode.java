public class BSTNode<K extends Comparable<K>> {
    KVPair<K> kvPair;
    BSTNode<K> left;
    BSTNode<K> right;

    public BSTNode(K key, Object value, int id) {
        this.kvPair = new KVPair<>(key, value, id);
    }
    
    // Rest of the methods remain the same
    public void setLeft(BSTNode<K> leftNode) {
        this.left = leftNode;
    }
    
    public void setRight(BSTNode<K> rightNode) {
        this.right = rightNode;
    }
    
    public KVPair<K> getKVPair() {
        return this.kvPair;
    }
    
    public BSTNode<K> getLeft() {
        return this.left;
    }
    
    public BSTNode<K> getRight() {
        return this.right;
    }

    // Modified to accept id as well
    public void setKVPair(K key, Object value, int id) {
        this.kvPair = new KVPair<>(key, value, id);
    }
}
