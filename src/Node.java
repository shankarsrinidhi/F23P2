public interface Node<K, V> {
    /**
     * Get the key of the node.
     *
     * @return the key
     */
    K getKey();

    /**
     * Get the value stored in the node.
     *
     * @return the value
     */
    V getValue();

    /**
     * Get the left child of the node.
     *
     * @return the left child
     */
    Node<K, V> getLeft();

    /**
     * Get the right child of the node.
     *
     * @return the right child
     */
    Node<K, V> getRight();

    /**
     * Set the left child of the node.
     *
     * @param left the node to set as left child
     */
    void setLeft(Node<K, V> left);

    /**
     * Set the right child of the node.
     *
     * @param right the node to set as right child
     */
    void setRight(Node<K, V> right);
}
