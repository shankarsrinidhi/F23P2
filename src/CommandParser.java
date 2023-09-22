import java.util.*;
import java.io.File;

/**
 * Parses commands for a command-line program.
 * 
 * This class takes an array of command-line inputs and then performs
 * operations like insert, delete, search and print based on the input commands.
 * 
 * @author Shankar Srinidhi Srinivas (shankarsrinidhi), Swetha Rajeev (rswetha)
 * @version 0.1
 * 
 */

public class CommandParser {

    private String[] args; // to hold the command-line arguments
    private String file;
    private String initMemorySize;
    private String initHashSize;

    /**
     * Constructs a CommandParser with the given command-line arguments.
     * 
     * @param args
     *            An array of command-line arguments:
     * @throws RuntimeException
     *             If args array length is not 3.
     */

    public CommandParser(String[] args) {

// if (args.length != 3) {
// throw new RuntimeException("Unexpected format for invocation");
// }
// initialize instance variables.
        this.args = args;
        this.initMemorySize = args[0];
        this.initHashSize = args[1];
        this.file = args[2];
    }


    /**
     * For future command check implementation.
     */
    public void commandCheck() {
        // System.out.println("in command check block");

    }


    /**
     * Parses and processes the input file and performs the operations.
     * Commands to insert, delete, search, and print seminars in the hash table
     * should be included in the input file.
     * 
     * @throws Exception
     *             if any error occurs during parsing or processing.
     */

    public void parseInput() {

        try {
            MemoryManager manager = new MemoryManager(Integer.parseInt(
                args[0]));
            HashTable ht = new HashTable(Integer.parseInt(initHashSize),
                manager);
            // System.out.println("Working Directory = " +
            // System.getProperty("user.dir"));
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNext()) {

                String cmd = sc.next();
                // Split the line into words based on whitespace.
                // String[] cmd = input.split("\\s");
                // switch-case to handle the first word in 'cmd'.
                switch (cmd) {
                    case "insert":
                        int insertId = sc.nextInt();
                        sc.nextLine();
                        String inputTitle = sc.nextLine().trim();
                        // String[] inputInfo = insertLines[1].split("\\s+");
                        String inputDate = sc.next();
                        int inputLength = sc.nextInt();
                        short inputX = sc.nextShort();
                        short inputY = sc.nextShort();
                        int inputCost = sc.nextInt();
                        sc.nextLine();
                        ArrayList<String> keyWordsAl = new ArrayList<String>();
                        Scanner lineScanner = new Scanner(sc.nextLine());
                        while (lineScanner.hasNext()) {

                            keyWordsAl.add(lineScanner.next());
                        }
                        String[] inputKeywords = new String[keyWordsAl.size()];
                        inputKeywords = keyWordsAl.toArray(inputKeywords);

                        String inputDesc = sc.nextLine().trim();

                        Seminar sem = new Seminar(insertId, inputTitle,
                            inputDate, inputLength, inputX, inputY, inputCost,
                            inputKeywords, inputDesc);

                        try {
                            byte[] size = sem.serialize();
                            // for (byte x1: size) System.out.print(x1);
                            if (size == null)
                                return;
                            else {
                            boolean success = ht.insertData(insertId, size);
                            if (success) {
                                System.out.println("ID: " + insertId
                                    + ", Title: " + inputTitle);
                                System.out.println("Date: " + inputDate
                                    + ", Length: " + inputLength + ", X: "
                                    + inputX + ", Y: " + inputY + ", Cost: "
                                    + inputCost);
                                System.out.println("Description: " + inputDesc);
                                System.out.print("Keywords: ");
                                for (int i = 0; i < inputKeywords.length; i++) {
                                    if (i != inputKeywords.length - 1)
                                        System.out.print(inputKeywords[i]
                                            + ", ");
                                    else
                                        System.out.print(inputKeywords[i]
                                            + "\n");
                                }
                                System.out.println("Size: " + size.length);
                            }
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                    case "delete":
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        // System.out.println("In delete block with id
                        // "+deleteId);
                        ht.deleteData(deleteId);
                        break;
                    case "search":
                        int searchId = sc.nextInt();
                        sc.nextLine();
                        // System.out.println("In search block with id
                        // "+searchId);
                        byte[] searchData = ht.searchData(searchId);
                        if (searchData != null) {
                            Seminar sm1 = new Seminar();
                            sm1 = sm1.deserialize(searchData);
                            System.out.println(sm1.toString());
                        }
                        break;
                    case "print":
                        // System.out.println("In print case and command is
                        // "+input.split("\\s+")[1].trim());
                        String ds = sc.next();
                        sc.nextLine();
                        if (ds.contains("hashtable")) {
                            // System.out.println("The command is
                            // "+command);
                            ht.printHashTable();
                        }
                        else  {
                            // System.out.println("Free block list
                            // "+manager.getCount());
                            manager.print();
                        }

                        break;
                }
            }

        }
        catch (Exception e) {
            // If an exception occurs, print the stack trace for debugging.
            e.printStackTrace();
        }
    }

}
