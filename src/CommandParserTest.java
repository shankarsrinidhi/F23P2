//import static org.junit.Assert.*;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintStream;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import student.TestCase;
//
///**
// * Test class for the CommandParser.
// * 
// * @author Shankar Srinidhi Srinivas (shankarsrinidhi), Swetha Rajeev (rswetha)
// * @version 0.1
// */
//public class CommandParserTest extends TestCase{
//    private final InputStream systemIn = System.in;
//    private final PrintStream systemOut = System.out;
//    private ByteArrayOutputStream testOutput;
//    
//
//    /**
//     * It replaces System.out with a ByteArrayOutputStream to capture the
//     * console output.
//     */
//
//    @Before
//    public void setOutputStream() {
//        testOutput = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(testOutput));
//    }
//
//    /**
//     * Restores the original system input and output streams.
//     */
//    @After
//    public void restoreInputStream() {
//        System.setIn(systemIn);
//        System.setOut(systemOut);
//    }
//
//    /**
//     * Tests the parseInput method with valid input using CommandParser.
//     * It checks whether the output is as expected.
//     * 
//     * @throws IOException
//     *             if there is an error in file operations.
//     */
//    @Test
//    public void testCommandParser() throws IOException {
//        String[] args = new String[3];
//        args[0] = "512";
//        args[1] = "4";
//        args[2] = "P2Sample_input.txt";
//
//        CommandParser cp = new CommandParser(args);
//        cp.parseInput();
//
//        String output = testOutput.toString();
//        String referenceOutput = encodeFile("P2Sample_output.txt");
//        assertFuzzyEquals(referenceOutput.trim(), output.trim());
//    }
//
//
//    /**
//     * Reads the contents of a file as a String.
//     *
//     * @param path
//     *            the path to the file to read
//     * @return the contents of the file as a string
//     * @throws IOException
//     *             if there is an error reading the file
//     */
//    private String encodeFile(String path) throws IOException {
//        byte[] encoded = Files.readAllBytes(Paths.get(path));
//        return new String(encoded, StandardCharsets.UTF_8);
//    }
//
//    @Test
//    public void test() {
//        fail("Not yet implemented");
//    }
//
//}
