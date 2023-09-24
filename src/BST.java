public class BST<K extends Comparable<K>> {
    private BSTNode< K > root;
 // Counter to keep track of the number of nodes
    private int nodeCount; 
    private int checkedNodeCount;
    private int equalNodeCount;
    public boolean nodeDeleted;
    
    public BST() {
        this.nodeCount = 0;
        this.checkedNodeCount =0;
        this.equalNodeCount =0;
        
    }


//    private static class Node<K extends Comparable<K>>  {
//     // KVPair object to hold key-value pair
//        KVPair<K> kvPair;
//        Node<K> left;
//        Node<K> right;
//
//        Node(K key, Object value) {
//            this.kvPair = new KVPair<>(key, value);
//        }
//    }
  
//
//    public void insert(K key, Object value) {
//        root = insert(root, new KVPair<>(key, value));
//        nodeCount++;
//    }
//
//
//    public BSTNode<K> insert(BSTNode<K> curr, KVPair<K> kvPair) {
//        if (curr == null) {
//            return new BSTNode<>(kvPair.getKey(), kvPair.getValue());
//        }
//
//        int compare = kvPair.getKey().compareTo(curr.kvPair.getKey());
//        if (compare <= 0) {
//            curr.left = insert(curr.left, kvPair);
//        } else {
//            curr.right = insert(curr.right, kvPair);
//        }
//
//        return curr;
//    }
    
//    //insert operation   
    public void insert(K key, Object value, int id) {
        root = insert(root, new KVPair<>(key, value, id)); // Assuming KVPair constructor can take id
        nodeCount++;
    }

    public BSTNode<K> insert(BSTNode<K> curr, KVPair<K> kvPair) {
        if (curr == null) {
            return new BSTNode<>(kvPair.getKey(), kvPair.getValue(), kvPair.getId());
        }

        int compare = kvPair.getKey().compareTo(curr.kvPair.getKey());
        if (compare <= 0) {
            curr.left = insert(curr.left, kvPair);
        } else {
            curr.right = insert(curr.right, kvPair);
        }

        return curr;
    }


    // Search operation
    public Object searchNode(K key) {
        return searchNode(root, key);
    }

    private Object searchNode(BSTNode<K> curr, K key) {
        if (curr == null) return null;

        int compare = key.compareTo(curr.kvPair.getKey());
        if (compare < 0) {
            return searchNode(curr.left, key);
        } else if (compare > 0) {
            return searchNode(curr.right, key);
        } else {
            return curr.kvPair.getValue();
        }
    }

    //remove operation

public void deleteNode(K key, int id) {
    nodeDeleted = false;  // Reset flag
    root = deleteNode(root, key, id);
    if (nodeDeleted) {
        nodeCount--; // Only decrement if a node was actually removed
    }
}

//    public void deleteNode(K key, int id) {
//        root = deleteNode(root, key, id);
//        if (root != null) {
//            nodeCount--; // Only decrement if a node was actually removed
//        }
//    }
//    public void deleteNode(K key, int id) {
//        int initialCount = nodeCount; // Store the initial node count
//        root = deleteNode(root, key, id);
//        if (initialCount != nodeCount) { // Check if a node was actually removed
//            nodeCount--; 
//        }
//    }



    public BSTNode<K> deleteNode(BSTNode<K> curr, K key, int id) {
        if (curr == null) 
            return null;

        int compare = key.compareTo(curr.kvPair.getKey());
        if (compare < 0) {
            curr.left = deleteNode(curr.left, key, id);
        } else if (compare > 0) {
            curr.right = deleteNode(curr.right, key, id);
        } else {
         // compare == 0, key is equal
            if (curr.kvPair.getId() == id) {
             // Node is deleted
                nodeDeleted = true; 
                if (curr.left == null) 
                    
                    return curr.right;
                if (curr.right == null) return curr.left;
             // Node has two children, replace with the maximum node in the left subtree
                BSTNode<K> temp = curr;
                curr = maximum(curr.left);
                curr.left = deleteMax(temp.left);
                curr.right = temp.right;
            } else {
                // If the ID doesn't match, continue searching in the left subtree
                curr.left = deleteNode(curr.left, key, id);
            }
        }
        return curr;
    }

    private BSTNode<K> maximum(BSTNode<K> curr) {
        if (curr.right == null) return curr;
        return maximum(curr.right);
    }

    private BSTNode<K> deleteMax(BSTNode<K> curr) {
        if (curr.right == null) return curr.left;
        curr.right = deleteMax(curr.right);
        return curr;
    }
    public int getNodeCount() {
        return nodeCount;
    }
    
    
    
    public void printBSTNode(K key) {
        printBSTNode(root,key);
    }
    
    private void printBSTNode(BSTNode<K> curr, K key) {
        if(curr == null) return;
        int compare = curr.getKVPair().compareTo(key);
        
        if(compare < 0) {
            printBSTNode(curr.getRight(), key);
        }
        if(compare == 0) {
            System.out.println(curr.getKVPair().getValue().toString());
        }
        if(compare > 0) {
            printBSTNode(curr.getLeft(), key);
        }
    }


    public void printBST() {
        if(nodeCount == 0) {
            System.out.println("This tree is empty");
            return;
        }
        printTraverseOrder(this.root);
        System.out.println();  // To end the line after printing all keys
        System.out.println("Number of records: " + nodeCount);
    }

    
    
    public void printInRange(K low,K high,Boolean check) {
        this.equalNodeCount=0;
        this.checkedNodeCount=0;
        printInRange(root, low, high);
        if(check == true) {
            System.out.println(this.checkedNodeCount+" nodes visited in this search");
        }
        
    }
    
    private void printInRange(BSTNode< K > curr,K low,K high) {
        this.checkedNodeCount ++;
        if(curr==null) 
            return;
        if(curr.getKVPair().compareTo(low) >= 0) {
            printInRange(curr.getLeft(), low, high);
        }
        if(curr.getKVPair().compareTo(low) >= 0 && curr.getKVPair().compareTo(high) <= 0) {
            this.equalNodeCount++;
            System.out.println(curr.getKVPair().getValue().toString());
        }
        if(curr.getKVPair().compareTo(high)<0) {
            printInRange(curr.getRight(), low, high);
        }
    }
    
    

    public void printNodesInRange(K low, K high) {
        printNodesInRange(root, low, high);
    }

    private void printNodesInRange(BSTNode<K> curr, K low, K high) {
        if (curr == null) return;

        int compareLow = low.compareTo(curr.kvPair.getKey());
        int compareHigh = high.compareTo(curr.kvPair.getKey());

        if (compareLow < 0) {
            printNodesInRange(curr.left, low, high);
        }

        if (compareLow <= 0 && compareHigh >= 0) {
            System.out.println(curr.kvPair);
        }

        if (compareHigh > 0) {
            printNodesInRange(curr.right, low, high);
        }
    }
    
//private void printTraverseOrder(BSTNode<K> curr,int depth) {
//        
//        if(curr==null) {
//            for(int i=0;i<depth;i++) {
//                System.out.print("  ");
//            }
//            System.out.println("null");
//            return;
//        }
//        printTraverseOrder(curr.getRight(),depth+1);
//        for(int i=0;i<depth;i++) {
//            System.out.print("  ");
//        }
//        System.out.println(curr.getKVPair().getKey());
//        printTraverseOrder(curr.getLeft(),depth+1);
//    }
    private void printTraverseOrder(BSTNode<K> curr) {
        if (curr == null) {
            return;
        }
        printTraverseOrder(curr.getLeft());
        System.out.print(curr.getKVPair().getKey() + " ");
        printTraverseOrder(curr.getRight());
    }
    public int getEqualNodeCount() {
        return this.equalNodeCount;
    }



}
