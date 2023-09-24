//public class EmptyNode implements Node<Integer, Seminar> {
//    // Singleton instance
//    private static final EmptyNode instance = new EmptyNode();
//
//    // Private constructor ensures no additional instances can be created
//    private EmptyNode() {}
//
//    // Returns the single instance of EmptyNode
//    public static EmptyNode getInstance() {
//        return instance;
//    }
//
//    // Implementations for methods defined in Node<K, V>
//    @Override
//    public Integer getKey() {
//        return null;
//    }
//
//    @Override
//    public Seminar getValue() {
//        return null;
//    }
//
//    @Override
//    public Node<Integer, Seminar> getLeft() {
//        return null;
//    }
//
//    @Override
//    public Node<Integer, Seminar> getRight() {
//        return null;
//    }
//
//    @Override
//    public void setLeft(Node<Integer, Seminar> left) {
//        // Do nothing, as it's an EmptyNode
//    }
//
//    @Override
//    public void setRight(Node<Integer, Seminar> right) {
//        // Do nothing, as it's an EmptyNode
//    }
//}
