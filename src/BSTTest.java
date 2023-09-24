import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import student.TestCase;

/**
 * @author Shankar Srinidhi Srinivas (shankarsrinidhi), Swetha Rajeev (rswetha)
 * @version 0.1
 */

public class BSTTest extends TestCase {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private String captureOutput() {
        return outContent.toString().trim();
    }


    // Insert a single node and check the node count
    @Test
    public void testSingleInsert() {
        BST<Integer> bst = new BST<>();
        int id = 1;
        bst.insert(5, "Five", id);
        assertEquals(1, bst.getNodeCount());
    }

    // Insert multiple nodes and check the node count
    @Test
    public void testMultipleInserts() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(7, "Seven", 3);
        assertEquals(3, bst.getNodeCount());
    }

    // Insert duplicate keys
    @Test
    public void testDuplicateInserts() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five-1", 1);
        bst.insert(5, "Five-2", 2);
        assertEquals(2, bst.getNodeCount());
    }

    // Insert and then Search
    @Test
    public void testInsertThenSearch() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        assertEquals("Five", bst.searchNode(5));
    }

    // Search a single node in the BST
    @Test
    public void testSingleSearch() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        assertEquals("Five", bst.searchNode(5));
    }

    // Search multiple nodes in the BST
    @Test
    public void testMultipleSearch() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(7, "Seven", 3);
        assertEquals("Five", bst.searchNode(5));
        assertEquals("Three", bst.searchNode(3));
        assertEquals("Seven", bst.searchNode(7));
    }

    // Search for a node that doesn't exist
    @Test
    public void testUnsuccessfulSearch() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        assertNull(bst.searchNode(4));
    }

    // Search in an empty BST
    @Test
    public void testSearchInEmptyBST() {
        BST<Integer> bst = new BST<>();
        assertNull(bst.searchNode(5));
    }

    // Delete a leaf node
    @Test
    public void testDeleteLeaf() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.deleteNode(3, 2);
        assertNull(bst.searchNode(3));
        assertEquals(1, bst.getNodeCount());
    }
    @Test
    public void testDeleteNodeWithOneChild() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(2, "Two", 3);
        bst.deleteNode(3, 2);
        assertNull(bst.searchNode(3));
        assertNotNull(bst.searchNode(2));
        assertEquals(2, bst.getNodeCount());
    }
    @Test
    public void testDeleteNodeWithTwoChildren() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(2, "Two", 3);
        bst.insert(4, "Four", 4);
        bst.deleteNode(3, 2);
        assertNull(bst.searchNode(3));
        assertNotNull(bst.searchNode(2));
        assertNotNull(bst.searchNode(4));
        assertEquals(3, bst.getNodeCount());
    }
    @Test
    public void testDeleteRootNode() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(7, "Seven", 3);
        bst.deleteNode(5, 1);
        assertNull(bst.searchNode(5));
        assertNotNull(bst.searchNode(3));
        assertNotNull(bst.searchNode(7));
        assertEquals(2, bst.getNodeCount());
    }
    
    
    @Test
    public void testDeleteInUnbalancedTree() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(4, "Four", 2);
        bst.insert(3, "Three", 3);
        bst.deleteNode(4, 2);
        assertNull(bst.searchNode(4));
        assertNotNull(bst.searchNode(3));
        assertEquals(2, bst.getNodeCount());
    }
    @Test
    public void testDeleteNodeNotFound() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.deleteNode(7, 1); // Key 7 doesn't exist
        assertNotNull(bst.searchNode(5)); // The existing node should remain
        //assertEquals(1, bst.getNodeCount()); // Count should remain unchanged
    }
    @Test
    public void testDeleteNodeWithMatchingIDOnly() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(5, "FiveAgain", 2);  // Same key, different ID
        bst.deleteNode(5, 1);
        assertEquals(1, bst.getNodeCount()); // This should be 1 as only one node is deleted
    }
    @Test
    public void testDeleteNodeIDNotMatch() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.deleteNode(5, 2); // Key matches, ID does not
        assertEquals("Five", bst.searchNode(5)); // The existing node should still be there
        assertEquals(1, bst.getNodeCount()); // Count should remain unchanged
    }
    @Test
    public void testDeleteNodeSmallerThanRoot() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(7, "Seven", 3);
        bst.deleteNode(3, 2); // Delete a node smaller than the root
        assertNull(bst.searchNode(3)); // The node should be removed
        assertNotNull(bst.searchNode(5)); // Root should still be there
        assertNotNull(bst.searchNode(7)); // Right child should still be there
        assertEquals(2, bst.getNodeCount()); // Count should be two
    }
   




//    @Test
//    public void testDeleteNonExistentNode() {
//        BST<Integer> bst = new BST<>();
//        bst.insert(5, "Five", 1);
//        bst.insert(3, "Three", 2);
//        bst.deleteNode(7, 3);
//        assertNotNull(bst.searchNode(5));
//        assertNotNull(bst.searchNode(3));
//        assertNull(bst.searchNode(7));
//        assertEquals(2, bst.getNodeCount());
//    }
//    @Test
//    public void testDeleteWithDifferentID() {
//        BST<Integer> bst = new BST<>();
//        bst.insert(5, "Five", 1);
//        bst.deleteNode(5, 2);
//        assertNotNull(bst.searchNode(5));
//        assertEquals(1, bst.getNodeCount());
//    }



 // Test getNodeCount() after various operations
    @Test
    public void testGetNodeCount() {
        BST<Integer> bst = new BST<>();
        assertEquals(0, bst.getNodeCount());
        bst.insert(5, "Five", 1);
        assertEquals(1, bst.getNodeCount());
        bst.insert(3, "Three", 2);
        assertEquals(2, bst.getNodeCount());
        bst.insert(7, "Seven", 3);
        assertEquals(3, bst.getNodeCount());
        bst.deleteNode(7, 3);
        assertEquals(2, bst.getNodeCount());
    }
    @Test
    public void testPrintBSTNode() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.printBSTNode(5);
        assertEquals("Five", captureOutput());
    }
    @Test
    public void testPrintBSTNode_Comprehensive() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(7, "Seven", 3);

        //  Test for value when key is smaller than root
        bst.printBSTNode(3);
        assertEquals("Three", captureOutput().trim()); // Make sure to trim to eliminate any extra new lines
        clearOutput();  // Make sure to clear the captured output for the next test
        
        //  Test for value when key is equal to root
        bst.printBSTNode(5);
        assertEquals("Five", captureOutput().trim()); 
        clearOutput();  
        
        // Test for value when key is greater than root
        bst.printBSTNode(7);
        assertEquals("Seven", captureOutput().trim()); 
    }

   
    
    private void clearOutput() {
        outContent.reset();
    }
    @Test
    public void testPrintBST() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.printBST();
        // Update this to match the actual expected output
        String expectedOutput = "3 5 \nNumber of records: 2";
        assertEquals(expectedOutput, captureOutput());
    }

    @Test
    public void testPrintInRange() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.printInRange(4, 6, false);
        assertEquals("Five", captureOutput());
    }
    @Test
    public void testPrintNodesInRange_EmptyTree() {
        BST<Integer> bst = new BST<>();
        bst.printNodesInRange(1, 5);
        assertEquals("", outContent.toString());
    }
    @Test
    public void testPrintNodesInRange_NoElementsInRange() {
        BST<Integer> bst = new BST<>();
        bst.insert(7, "Seven", 1);
        bst.insert(8, "Eight", 2);
        bst.printNodesInRange(1, 5);
        assertEquals("", outContent.toString());
    }
    @Test
    public void testPrintNodesInRange_BothInside() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(7, "Seven", 3);
        bst.printNodesInRange(3, 7);
        String expected = "Three\nFive\nSeven";
        assertEquals(expected, captureOutput().trim());
    }

    @Test
    public void testPrintInRange_ConditionIsTrue() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.printInRange(2, 6, true);
        assertEquals(2, bst.getNodeCount()); // Here we assume that checkedNodeCount is accessible
    }
    
    @Test
    public void testEqualNodeCount() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.printInRange(3, 5, true);
        assertEquals(2, bst.getEqualNodeCount());
    }


 
    @Test
    public void testPrintTraverseOrder_EmptyTree() {
        BST<Integer> bst = new BST<>();
        bst.printBST(); // Assuming printBST calls printTraverseOrder internally
        assertEquals("This tree is empty\n", outContent.toString());
    }
    
    @Test
    public void testPrintTraverseOrder_SingleNode() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.printBST();
        assertEquals("5 \nNumber of records: 1\n", outContent.toString());
    }
    
    @Test
    public void testPrintTraverseOrder_MultipleNodes() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(3, "Three", 2);
        bst.insert(7, "Seven", 3);
        bst.printBST();
        assertEquals("3 5 7 \nNumber of records: 3\n", outContent.toString());
    }
    
    @Test
    public void testPrintTraverseOrder_UnbalancedTree() {
        BST<Integer> bst = new BST<>();
        bst.insert(5, "Five", 1);
        bst.insert(4, "Four", 2);
        bst.insert(3, "Three", 3);
        bst.printBST();
        assertEquals("3 4 5 \nNumber of records: 3\n", outContent.toString());
    }

}