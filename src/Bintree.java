//public class Bintree {
//    private Node<Integer, Seminar> root;
//
//    public Bintree() {
//        root = null;
//    }
//
//    public void insert(Seminar seminar) {
//        root = insertHelp(root, seminar, true);
//    }
//
//    private Node<Integer, Seminar> insertHelp(Node<Integer, Seminar> node, Seminar seminar, boolean xLevel) {
//        if (node == null) {
//            return new BintreeNode(seminar);
//        }
//
//        int compare = xLevel ? Integer.compare(seminar.x(), node.getValue().x()) : Integer.compare(seminar.y(), node.getValue().y());
//
//        if (compare < 0) {
//            node.setLeft(insertHelp(node.getLeft(), seminar, !xLevel));
//        } else {
//            node.setRight(insertHelp(node.getRight(), seminar, !xLevel));
//        }
//
//        return node;
//    }
//
//
//
//    public void search(int x, int y, int radius) {
//        searchHelp(root, x, y, radius, true);
//    }
//
//    private void searchHelp(Node<Integer, Seminar> node, int x, int y, int radius, boolean xLevel) {
//        if (node == null) {
//            return;
//        }
//
//        Seminar seminar = node.getValue();
//
//        int dx = x - seminar.x();
//        int dy = y - seminar.y();
//        int distanceSquared = dx * dx + dy * dy;
//
//        if (distanceSquared <= radius * radius) {
//            System.out.println("Found a record within radius: " + seminar);
//        }
//
//        int compare = xLevel ? dx : dy;
//
//        if (compare > -radius) {
//            searchHelp(node.getRight(), x, y, radius, !xLevel);
//        }
//        if (compare < radius) {
//            searchHelp(node.getLeft(), x, y, radius, !xLevel);
//        }
//    }
//
//    public void delete(int id) {
//        // Delete logic
//        // Deleting nodes while maintaining the Bintree property could be quite involved.
//        // Placeholder for now.
//    }
//}
