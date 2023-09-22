//public class BintreeNode implements Node<Integer, Seminar> {
//    private Seminar value;
//    private BintreeNode left, right;
//
//    public BintreeNode(Seminar value) {
//        this.value = value;
//        this.left = null;
//        this.right = null;
//    }
//
//    @Override
//    public Integer getKey() {
//        return value.id(); // Assuming the ID is unique and can serve as the key
//    }
//
//    @Override
//    public Seminar getValue() {
//        return value;
//    }
//
//    @Override
//    public Node<Integer, Seminar> getLeft() {
//        return left;
//    }
//
//    @Override
//    public Node<Integer, Seminar> getRight() {
//        return right;
//    }
//
//    @Override
//    public void setLeft(Node<Integer, Seminar> left) {
//        this.left = (BintreeNode) left;
//    }
//
//    @Override
//    public void setRight(Node<Integer, Seminar> right) {
//        this.right = (BintreeNode) right;
//    }
//}
