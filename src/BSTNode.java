class Node<K extends Comparable<K>> {
    KVPair<K> kvPair;
    Node<K> left;
    Node<K> right;

    public Node(K key, Object value) {
        this.kvPair = new KVPair<>(key, value);
    }
}
